package eu.faircode.netguard.dnsfilter;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DnsFilterStarter {

    private static final String TAG = "DnsFilterStarter";

    public static void start(Context context) {
        try {
            if (isAutostartEnabled(context)) {
                Log.i(TAG, "Khởi động DNS Filter theo cấu hình autostart");
                DnsServer.start();
            } else {
                Log.i(TAG, "Autostart DNS Filter bị tắt");
            }
        } catch (Exception e) {
            Log.e(TAG, "Lỗi khi khởi động DNS Filter", e);
        }
    }

    public static boolean isAutostartEnabled(Context context) {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(context.getAssets().open("dnsfilter.conf"))
            );
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("autostart=")) {
                    return line.endsWith("true");
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Không thể đọc dnsfilter.conf", e);
        }
        return false;
    }
}
