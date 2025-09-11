package eu.faircode.netguard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import eu.faircode.netguard.R;

public class SettingsFragment extends Fragment {

    private Switch switchLogging;
    private Spinner spinnerDns;
    private Button btnExport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switchLogging = view.findViewById(R.id.switch_logging);
        spinnerDns = view.findViewById(R.id.spinner_dns);
        btnExport = view.findViewById(R.id.btn_export_config);

        // Load trạng thái ghi log từ SharedPreferences
        boolean isLoggingEnabled = requireContext()
                .getSharedPreferences("settings", 0)
                .getBoolean("logging_enabled", false);
        switchLogging.setChecked(isLoggingEnabled);

        switchLogging.setOnCheckedChangeListener((buttonView, isChecked) -> {
            requireContext()
                .getSharedPreferences("settings", 0)
                .edit()
                .putBoolean("logging_enabled", isChecked)
                .apply();
            Toast.makeText(getContext(),
                isChecked ? "Đã bật ghi log" : "Đã tắt ghi log",
                Toast.LENGTH_SHORT).show();
        });

        // TODO: Load danh sách DNS server vào spinnerDns

        btnExport.setOnClickListener(v -> {
            // TODO: Thực hiện xuất cấu hình
            Toast.makeText(getContext(),
                "Đã xuất cấu hình thành công",
                Toast.LENGTH_SHORT).show();
        });
    }
}
