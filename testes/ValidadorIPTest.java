package testes;

import org.junit.jupiter.api.Test;
import src.ValidadorIP;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorIPTest {

    private static final String IPV4_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

    @Test
    public void testValidIPv4() {
        ValidadorIP validator = ValidadorIP.getInstance();
        assertTrue(validator.isValidIPv4("192.168.1.1", IPV4_PATTERN));
        assertTrue(validator.isValidIPv4("0.0.0.0", IPV4_PATTERN));
        assertTrue(validator.isValidIPv4("255.255.255.255", IPV4_PATTERN));
        assertFalse(validator.isValidIPv4("192.168.1.256", IPV4_PATTERN));
        assertFalse(validator.isValidIPv4("192.168.1.1.1", IPV4_PATTERN));
        assertFalse(validator.isValidIPv4("abcd:1234::", IPV4_PATTERN));
    }

    @Test
    public void testValidIP() {
        ValidadorIP validator = ValidadorIP.getInstance();
        assertTrue(validator.isValidIP("192.168.1.1", IPV4_PATTERN));
        assertFalse(validator.isValidIP("2001:db8::ff00:42:8329", IPV4_PATTERN));
        assertFalse(validator.isValidIP("invalid_ip", IPV4_PATTERN));
    }

    @Test
    public void testCanResolveIP() {
        ValidadorIP validator = ValidadorIP.getInstance();
        assertTrue(validator.canResolveIP("192.168.1.1"));
        assertTrue(validator.canResolveIP("127.0.0.1"));
        assertFalse(validator.canResolveIP("256.256.256.256"));
    }
}