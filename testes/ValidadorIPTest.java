package testes;

import org.junit.jupiter.api.Test;
import src.ValidadorIP;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorIPTest {

    @Test
    public void testValidIPv4() {
        ValidadorIP validator = ValidadorIP.getInstance();
        assertTrue(validator.isValidIPv4("192.168.1.1"));
        assertTrue(validator.isValidIPv4("0.0.0.0"));
        assertTrue(validator.isValidIPv4("255.255.255.255"));
        assertFalse(validator.isValidIPv4("192.168.1.256"));
        assertFalse(validator.isValidIPv4("192.168.1.1.1"));
        assertFalse(validator.isValidIPv4("abcd:1234::"));
    }

    @Test
    public void testValidIP() {
        ValidadorIP validator = ValidadorIP.getInstance();
        assertTrue(validator.isValidIP("192.168.1.1"));
        assertFalse(validator.isValidIP("2001:db8::ff00:42:8329"));
        assertFalse(validator.isValidIP("invalid_ip"));
    }

    @Test
    public void testCanResolveIP() {
        ValidadorIP validator = ValidadorIP.getInstance();
        assertTrue(validator.canResolveIP("192.168.1.1"));
        assertTrue(validator.canResolveIP("127.0.0.1"));
        assertFalse(validator.canResolveIP("256.256.256.256"));
    }
}