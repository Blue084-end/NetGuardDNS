package eu.faircode.netguard.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.ViewHolder> {

    public interface OnDomainRemoveListener {
        void onRemove(String domain);
    }

    private final List<String> domains;
    private final OnDomainRemoveListener listener;

    public DomainAdapter(List<String> domains, OnDomainRemoveListener listener) {
        this.domains = domains;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_domain, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String domain = domains.get(position);
        holder.domainText.setText(domain);
        holder.btnRemove.setOnClickListener(v -> {
            listener.onRemove(domain);
            domains.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return domains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView domainText;
        ImageButton btnRemove;

        public ViewHolder(View itemView) {
            super(itemView);
            domainText = itemView.findViewById(R.id.text_domain);
            btnRemove = itemView.findViewById(R.id.btn_remove_domain);
        }
    }
}
