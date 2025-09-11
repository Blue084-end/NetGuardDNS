package eu.faircode.netguard.dnsfilter;

import android.util.Patterns;

import java.util.regex.Pattern;

public class DomainUtils {

    // Regex đơn giản để kiểm tra tên miền hợp lệ
    private static final Pattern DOMAIN_PATTERN = Pattern.compile("^(?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.(?!-)(?:[A-Za-z0-9-]{1,63}\\.)*[A-Za-z]{2,6}$");

    /**
     * Kiểm tra tên miền có hợp lệ không
     */
    public static boolean isValidDomain(String domain) {
        if (domain == null || domain.trim().isEmpty())
            return false;

        domain = domain.trim().toLowerCase();

        // Loại bỏ http:// hoặc https:// nếu có
        if (domain.startsWith("http://"))
            domain = domain.substring(7);
        else if (domain.startsWith("https://"))
            domain = domain.substring(8);

        // Loại bỏ phần path nếu có
        int slashIndex = domain.indexOf('/');
        if (slashIndex != -1)
            domain = domain.substring(0, slashIndex);

        return DOMAIN_PATTERN.matcher(domain).matches();
    }

    /**
     * Chuẩn hóa tên miền: viết thường, loại bỏ tiền tố
     */
    public static String normalizeDomain(String domain) {
        if (domain == null)
            return "";

        domain = domain.trim().toLowerCase();

        if (domain.startsWith("http://"))
            domain = domain.substring(7);
        else if (domain.startsWith("https://"))
            domain = domain.substring(8);

        int slashIndex = domain.indexOf('/');
        if (slashIndex != -1)
            domain = domain.substring(0, slashIndex);

        return domain;
    }
}
