package Winter2022;

public class Pallindrome {
    public static void main(String[] args) {
        System.out.println(isPallindrome("abbad"));

    }

    static boolean isPallindrome(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
