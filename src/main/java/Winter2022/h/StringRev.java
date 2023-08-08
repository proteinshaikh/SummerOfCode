package Winter2022.h;

public class StringRev {
    public static void main(String[] args) {
        System.out.println(reverseString("zeeshan shaikh %#"));
    }


    static String reverseString(String str) {

        char[] chars = str.toCharArray();
        int len = chars.length;

        char[] tempChars = new char[len];

        for (int i = 0; i < len; i++) {
            tempChars[i] = chars[len - i - 1];
        }

        return new String(tempChars);
    }
}
