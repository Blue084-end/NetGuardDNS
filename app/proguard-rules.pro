# Giữ lại các lớp chính không bị rút gọn
-keep public class eu.faircode.netguard.** { *; }
-keep public class eu.faircode.netguard.ui.** { *; }
-keep public class eu.faircode.netguard.viewmodel.** { *; }
-keep public class eu.faircode.netguard.dnsfilter.** { *; }

# Giữ lại các lớp sử dụng bởi Android framework
-keepclassmembers class * {
    public <init>(android.content.Context);
}

# Giữ lại các lớp sử dụng trong layout XML
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

# Giữ lại các lớp sử dụng ViewBinding (nếu dùng)
-keep class **ViewBinding { *; }

# Giữ lại các lớp sử dụng bởi BroadcastReceiver
-keep class * extends android.content.BroadcastReceiver {
    <init>();
    public void onReceive(android.content.Context, android.content.Intent);
}

# Giữ lại các lớp sử dụng bởi Service
-keep class * extends android.app.Service {
    <init>();
    public void onStartCommand(...);
}

# Giữ lại các lớp sử dụng bởi RecyclerView.Adapter
-keep class * extends androidx.recyclerview.widget.RecyclerView$Adapter {
    <init>(...);
    public void onBindViewHolder(...);
    public int getItemCount();
}

# Tắt cảnh báo không cần thiết
-dontwarn android.support.**
-dontwarn androidx.**

# Tùy chọn: ghi log để debug ProGuard
# -printmapping mapping.txt
