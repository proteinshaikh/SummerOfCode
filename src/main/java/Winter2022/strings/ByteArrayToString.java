package Winter2022.strings;

import java.nio.charset.StandardCharsets;

public class ByteArrayToString {
    public static void main(String[] args) {
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes[0]);
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
