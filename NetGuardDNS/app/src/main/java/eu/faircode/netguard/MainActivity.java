package eu.faircode.netguard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import eu.faircode.netguard.ui.AppControlFragment;
import eu.faircode.netguard.ui.DnsFilterFragment;
import eu.faircode.netguard.ui.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment;
            switch (item.getItemId()) {
                case R.id.nav_apps:
                    selectedFragment = new AppControlFragment();
                    break;
                case R.id.nav_dns:
                    selectedFragment = new DnsFilterFragment();
                    break;
                case R.id.nav_settings:
                    selectedFragment = new SettingsFragment();
                    break;
                default:
                    selectedFragment = new AppControlFragment();
            }
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();
            return true;
        });

        // Mặc định hiển thị tab ứng dụng
        navigation.setSelectedItemId(R.id.nav_apps);
    }
}
