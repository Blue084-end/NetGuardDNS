package eu.faircode.netguard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import eu.faircode.netguard.R;
import eu.faircode.netguard.viewmodel.DnsFilterViewModel;

public class DnsFilterFragment extends Fragment {

    private DnsFilterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dns_filter, container, false);

        viewModel = new ViewModelProvider(this).get(DnsFilterViewModel.class);

        Switch switchDns = view.findViewById(R.id.switch_dns_filter);
        RecyclerView domainList = view.findViewById(R.id.recycler_domain_list);
        EditText inputDomain = view.findViewById(R.id.edit_domain);
        Button btnAdd = view.findViewById(R.id.btn_add_domain);

        switchDns.setChecked(viewModel.isFilterEnabled());
        switchDns.setOnCheckedChangeListener((buttonView, isChecked) -> {
            viewModel.setFilterEnabled(isChecked);
        });

        btnAdd.setOnClickListener(v -> {
            String domain = inputDomain.getText().toString().trim();
            if (!domain.isEmpty()) {
                viewModel.addDomain(domain);
                inputDomain.setText("");
            }
        });

        // TODO: Gắn adapter cho domainList để hiển thị danh sách tên miền

        return view;
    }
}
