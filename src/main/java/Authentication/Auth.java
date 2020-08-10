package Authentication;


import java.util.Base64;

public class Auth {
    public static void main(String[] args) {
        String clientCredentials= "admin:password";
        String base64ClientCredentials= Base64.getEncoder().encodeToString(clientCredentials.getBytes());
        System.out.println("Authorization : basic "+base64ClientCredentials);
    }
}
