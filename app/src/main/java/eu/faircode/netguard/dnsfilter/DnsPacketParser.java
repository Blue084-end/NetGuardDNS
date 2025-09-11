public class DnsPacketParser {
    public static String extractDomain(Packet packet) {
        byte[] data = packet.getPayload();
        // TODO: Phân tích gói DNS để lấy tên miền từ phần truy vấn
        // Có thể dùng thư viện hoặc viết parser đơn giản
        return parseDomainFromDnsQuery(data);
    }
}
