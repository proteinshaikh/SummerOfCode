package CoreJava;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Hashing256 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String block = "samplestring";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(block.getBytes(StandardCharsets.UTF_8));
        String output = HexFormat.of().formatHex(hash);
        System.out.println(output.toLowerCase());
    }
}
