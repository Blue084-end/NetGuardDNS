if (packet.isUDP() && packet.getDestinationPort() == 53) {
    String domain = DnsPacketParser.extractDomain(packet);
    if (domain != null) {
        InetAddress resolved = DnsServer.resolve(domain);
        if (resolved == null) {
            // Bị chặn → trả về IP 0.0.0.0
            packet.setResponseAddress("0.0.0.0");
        } else {
            // Được phép → trả về IP thật
            packet.setResponseAddress(resolved.getHostAddress());
        }
        sendResponse(packet);
        return;
    }
}
