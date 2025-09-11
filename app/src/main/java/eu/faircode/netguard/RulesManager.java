package eu.faircode.netguard;

import android.content.Context;
import android.content.SharedPreferences;

public class RulesManager {

    private static final String PREF_NAME = "netguard_rules";

    /**
     * Lưu trạng thái truy cập Wi-Fi cho một ứng dụng
     */
    public static void setWifiAllowed(Context context, String packageName, boolean allowed) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(packageName + "_wifi", allowed).apply();
    }

    /**
     * Lưu trạng thái truy cập dữ liệu di động cho một ứng dụng
     */
    public static void setMobileAllowed(Context context, String packageName, boolean allowed) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(packageName + "_mobile", allowed).apply();
    }

    /**
     * Kiểm tra ứng dụng có được phép dùng Wi-Fi không
     */
    public static boolean isWifiAllowed(Context context, String packageName) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(packageName + "_wifi", true); // mặc định là cho phép
    }

    /**
     * Kiểm tra ứng dụng có được phép dùng dữ liệu di động không
     */
    public static boolean isMobileAllowed(Context context, String packageName) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(packageName + "_mobile", true); // mặc định là cho phép
    }

    /**
     * Xóa toàn bộ quy tắc (nếu cần reset)
     */
    public static void clearAllRules(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().clear().apply();
    }
}
