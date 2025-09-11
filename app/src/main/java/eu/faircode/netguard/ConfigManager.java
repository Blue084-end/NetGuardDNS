package eu.faircode.netguard;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.List;

public class ConfigManager {

    private static final String PREF_NAME = "netguard_config";

    /**
     * Bật/tắt ghi log
     */
    public static void setLoggingEnabled(Context context, boolean enabled) {
        getPrefs(context).edit().putBoolean("logging_enabled", enabled).apply();
    }

    public static boolean isLoggingEnabled(Context context) {
        return getPrefs(context).getBoolean("logging_enabled", false);
    }

    /**
     * Lưu DNS server được chọn
     */
    public static void setSelectedDnsServer(Context context, String dnsServer) {
        getPrefs(context).edit().putString("selected_dns", dnsServer).apply();
    }

    public static String getSelectedDnsServer(Context context) {
        return getPrefs(context).getString("selected_dns", "1.1.1.1"); // mặc định Cloudflare
    }

    /**
     * Bật/tắt chế độ khởi động DNS Filter khi máy khởi động
     */
    public static void setDnsAutostartEnabled(Context context, boolean enabled) {
        getPrefs(context).edit().putBoolean("dns_autostart", enabled).apply();
    }

    public static boolean isDnsAutostartEnabled(Context context) {
        return getPrefs(context).getBoolean("dns_autostart", false);
    }

    /**
     * Danh sách DNS server gợi ý
     */
    public static List<String> getSuggestedDnsServers() {
        return Arrays.asList(
            "1.1.1.1 (Cloudflare)",
            "8.8.8.8 (Google)",
            "9.9.9.9 (Quad9)",
            "94.140.14.14 (AdGuard)"
        );
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
