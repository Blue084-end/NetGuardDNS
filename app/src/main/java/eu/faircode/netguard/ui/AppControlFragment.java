
package eu.faircode.netguard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import eu.faircode.netguard.R;
import eu.faircode.netguard.viewmodel.AppControlViewModel;

public class AppControlFragment extends Fragment {

    private AppControlViewModel viewModel;
    private RecyclerView recyclerView;
    private AppListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_control, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.app_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(AppControlViewModel.class);

        viewModel.getAppList().observe(getViewLifecycleOwner(), appList -> {
            adapter = new AppListAdapter(appList, requireContext().getPackageManager(), new AppListAdapter.OnToggleListener() {
                @Override
                public void onWifiToggle(String packageName, boolean enabled) {
                    viewModel.setWifiAllowed(packageName, enabled);
                }

                @Override
                public void onMobileToggle(String packageName, boolean enabled) {
                    viewModel.setMobileAllowed(packageName, enabled);
                }
            });
            recyclerView.setAdapter(adapter);
        });
    }
}
