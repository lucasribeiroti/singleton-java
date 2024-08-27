package src;

public class RegistroUsuario {

    private ValidadorIP validadorIP;

    public RegistroUsuario() {
        this.validadorIP = ValidadorIP.getInstance();
    }

    public boolean registrarUsuario(String nome, String enderecoIP) {
        if (validadorIP.isValidIPv4(enderecoIP)) {
            System.out.println("Usuário " + nome + " registrado com IP " + enderecoIP);
            return true;
        }else {
            System.out.println("IP inválido: " + enderecoIP);
            return false;
        }
    }
}