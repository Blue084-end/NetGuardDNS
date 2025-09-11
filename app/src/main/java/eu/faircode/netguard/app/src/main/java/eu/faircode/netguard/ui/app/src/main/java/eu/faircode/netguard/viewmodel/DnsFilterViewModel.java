package eu.faircode.netguard.viewmodel;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class DnsFilterViewModel extends ViewModel {
    private boolean filterEnabled = false;
    private final List<String> domainList = new ArrayList<>();

    public boolean isFilterEnabled() {
        return filterEnabled;
    }

    public void setFilterEnabled(boolean enabled) {
        this.filterEnabled = enabled;
        // TODO: Gọi DnsServer để bật/tắt filter
    }

    public void addDomain(String domain) {
        domainList.add(domain);
        // TODO: Cập nhật FilterList
    }

    public List<String> getDomainList() {
        return domainList;
    }
}
