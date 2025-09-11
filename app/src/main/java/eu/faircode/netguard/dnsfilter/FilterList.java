public class FilterList {
    private static final Set<String> blockedDomains = new HashSet<>();

    public static void add(String domain) {
        blockedDomains.add(domain.toLowerCase());
    }

    public static void remove(String domain) {
        blockedDomains.remove(domain.toLowerCase());
    }

    public static boolean isBlocked(String domain) {
        return blockedDomains.contains(domain.toLowerCase());
    }

    public static List<String> getAll() {
        return new ArrayList<>(blockedDomains);
    }
}
