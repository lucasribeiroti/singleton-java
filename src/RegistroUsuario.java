package src;

import java.util.regex.Pattern;

public class RegistroUsuario {

    private ValidadorIP validadorIP;
    private static final String IPV4_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

    public RegistroUsuario() {
        this.validadorIP = ValidadorIP.getInstance();
    }

    public boolean registrarUsuario(String nome, String enderecoIP) {
        if (validadorIP.isValidIPv4(enderecoIP, IPV4_PATTERN)) {
            System.out.println("Usuário " + nome + " registrado com IP " + enderecoIP);
            return true;
        } else {
            System.out.println("IP inválido: " + enderecoIP);
            return false;
        }
    }
}