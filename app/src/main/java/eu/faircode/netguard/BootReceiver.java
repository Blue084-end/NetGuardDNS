package eu.faircode.netguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.i("BootReceiver", "Thiết bị vừa khởi động, kiểm tra khởi động dịch vụ...");

            // Khởi động lại VPN nếu cần
            Intent vpnIntent = new Intent(context, NetGuardService.class);
            vpnIntent.setAction("eu.faircode.netguard.START_VPN");
            context.startService(vpnIntent);

            // Khởi động lại DNS Filter nếu được cấu hình autostart
            if (ConfigManager.isDnsAutostartEnabled(context)) {
                DnsFilterStarter.start(context);
            }
        }
    }
}
