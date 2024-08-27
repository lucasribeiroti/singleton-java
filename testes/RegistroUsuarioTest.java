package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.RegistroUsuario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistroUsuarioTest {

    private RegistroUsuario registroUsuario;

    @BeforeEach
    public void setUp() {
        registroUsuario = new RegistroUsuario();
    }

    @Test
    public void testRegistrarUsuarioComIPv4Valido() {
        boolean result = registroUsuario.registrarUsuario("Lucas", "192.168.1.1");
        assertTrue(result, "O IP 192.168.1.1 deveria ser considerado válido e o registro deveria ser bem-sucedido.");
    }

    @Test
    public void testRegistrarUsuarioComIPv4Invalido() {
        boolean result = registroUsuario.registrarUsuario("Lucas", "256.256.256.256");
        assertFalse(result, "O IP 256.256.256.256 deveria ser considerado inválido e o registro deveria falhar.");
    }
}