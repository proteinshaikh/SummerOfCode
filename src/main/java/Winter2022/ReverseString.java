package Winter2022;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Using charAt:           " + getReversed("zeeshan"));
        System.out.println("Using StringBuffer:     " + getReversedBuffer("zeeshan"));
        System.out.println("Using StringBuilder:    " + getReversedBuilder("zeeshan"));

    }

    static String getReversed(String str) {
        String reversed = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            reversed += str.charAt(len - i - 1);
        }
        return reversed;
    }

    static String getReversedBuffer(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    static String getReversedBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
