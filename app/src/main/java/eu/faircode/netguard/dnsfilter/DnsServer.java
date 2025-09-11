public class DnsServer {
    public static InetAddress resolve(String domain) {
        if (FilterList.isBlocked(domain)) {
            return null;
        }
        // Gọi DNS thật (ví dụ: 1.1.1.1)
        return DnsResolver.query(domain);
    }
}
