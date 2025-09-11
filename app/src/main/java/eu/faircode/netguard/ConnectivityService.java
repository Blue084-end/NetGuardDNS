package eu.faircode.netguard;

import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.IBinder;
import android.util.Log;

public class ConnectivityService extends Service {

    private static final String TAG = "ConnectivityService";
    private ConnectivityManager connectivityManager;
    private ConnectivityManager.NetworkCallback networkCallback;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Khởi động dịch vụ giám sát kết nối");

        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                Log.i(TAG, "Mạng đã kết nối: " + network.toString());
                // TODO: Gửi thông báo cho NetGuardService hoặc DNS Filter
            }

            @Override
            public void onLost(Network network) {
                Log.i(TAG, "Mạng đã mất kết nối: " + network.toString());
                // TODO: Xử lý khi mất mạng
            }
        };

        NetworkRequest request = new NetworkRequest.Builder().build();
        connectivityManager.registerNetworkCallback(request, networkCallback);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Hủy đăng ký giám sát kết nối");
        if (connectivityManager != null && networkCallback != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // Không hỗ trợ bind
    }
}

