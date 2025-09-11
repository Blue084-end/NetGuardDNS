
package eu.faircode.netguard.viewmodel;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import eu.faircode.netguard.RulesManager;

public class AppControlViewModel extends AndroidViewModel {

    private final MutableLiveData<List<ApplicationInfo>> appListLiveData = new MutableLiveData<>();

    public AppControlViewModel(@NonNull Application application) {
        super(application);
        loadInstalledApps();
    }

    private void loadInstalledApps() {
        PackageManager pm = getApplication().getPackageManager();
        List<ApplicationInfo> allApps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        List<ApplicationInfo> userApps = new ArrayList<>();

        for (ApplicationInfo appInfo : allApps) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                userApps.add(appInfo);
            }
        }

        appListLiveData.setValue(userApps);
    }

    public LiveData<List<ApplicationInfo>> getAppList() {
        return appListLiveData;
    }

    public boolean isWifiAllowed(String packageName) {
        return RulesManager.isWifiAllowed(getApplication(), packageName);
    }

    public boolean isMobileAllowed(String packageName) {
        return RulesManager.isMobileAllowed(getApplication(), packageName);
    }

    public void setWifiAllowed(String packageName, boolean allowed) {
        RulesManager.setWifiAllowed(getApplication(), packageName, allowed);
    }

    public void setMobileAllowed(String packageName, boolean allowed) {
        RulesManager.setMobileAllowed(getApplication(), packageName, allowed);
    }
}
