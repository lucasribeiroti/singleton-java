package src;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class ValidadorIP {

    private ValidadorIP() {};
    private static final ValidadorIP instance = new ValidadorIP();
    public static ValidadorIP getInstance() {
        return instance;
    }

    public boolean isValidIPv4(String ip, Pattern ipv4Pattern) {
        return ip != null && ipv4Pattern.matcher(ip).matches();
    }

    public boolean isValidIP(String ip, Pattern ipv4Pattern) {
        return isValidIPv4(ip, ipv4Pattern);
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