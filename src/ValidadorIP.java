package src;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class ValidadorIP {

    private static ValidadorIP instance;
    private static final String IPV4_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

    private ValidadorIP() {
    }

    public static synchronized ValidadorIP getInstance() {
        if (instance == null) {
            instance = new ValidadorIP();
        }
        return instance;
    }

    public boolean isValidIPv4(String ip) {
        return ip != null && IPV4_PATTERN.matcher(ip).matches();
    }

    public boolean isValidIP(String ip) {
        return isValidIPv4(ip);
    }

    public boolean canResolveIP(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address.getHostAddress().equals(ip);
        } catch (UnknownHostException e) {
            return false;
        }
    }
}