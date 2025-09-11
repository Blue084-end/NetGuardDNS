package eu.faircode.netguard;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogService extends Service {

    private static final String TAG = "LogService";
    private static final String LOG_FILE = "/sdcard/NetGuardDNS/log.txt";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "LogService đã khởi động");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String message = intent.getStringExtra("log_message");
        if (message != null) {
            writeLog(message);
        }
        return START_NOT_STICKY;
    }

    private void writeLog(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        String logEntry = timestamp + " - " + message + "\n";

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.append(logEntry);
            Log.d(TAG, "Đã ghi log: " + logEntry);
        } catch (IOException e) {
            Log.e(TAG, "Lỗi ghi log", e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "LogService đã dừng");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // Không hỗ trợ bind
    }
}
