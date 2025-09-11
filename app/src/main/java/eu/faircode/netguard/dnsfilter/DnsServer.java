public class DnsServer {
    public static InetAddress resolve(String domain) {
        if (FilterList.isBlocked(domain)) {
            return null;
        }
        // Gọi DNS thật (ví dụ: 1.1.1.1)
        return DnsResolver.query(domain);
    }
}

////bo sung

public class DnsServer {
    private static boolean running = false;

    public static void start() {
        if (running) return;
        running = true;
        // TODO: Khởi động DNS proxy, lắng nghe truy vấn
    }

    public static void stop() {
        running = false;
        // TODO: Dừng DNS proxy
    }

    public static InetAddress resolve(String domain) {
        if (FilterList.isBlocked(domain)) {
            return null;
        }
        return DnsResolver.query(domain);
    }
}
