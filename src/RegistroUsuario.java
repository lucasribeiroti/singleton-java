package src;

public class RegistroUsuario {

    private ValidadorIP validadorIP;

    public RegistroUsuario() {
        this.validadorIP = ValidadorIP.getInstance();
    }

    public boolean registerUser(String username, String ipAddress) {
        if (validadorIP.isValidIPv4(ipAddress)) {
            System.out.println("Usuário " + username + " registrado com IP " + ipAddress);
            return true;
        }else {
            System.out.println("IP inválido: " + ipAddress);
            return false;
        }
    }
}