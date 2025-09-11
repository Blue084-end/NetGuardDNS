public class DnsResolver {
    public static InetAddress query(String domain) {
        try {
            return InetAddress.getByName(domain);
        } catch (UnknownHostException e) {
            return null;
        }
    }
}
