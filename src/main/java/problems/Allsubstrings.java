package problems;

public class Allsubstrings {
    public static void main(String[] args) {

        String str = "abcd";
        char[] chars = str.toCharArray();
        int n = str.length();
        Character[] chararr = new Character[n];
        int i, j;

        for (i = 1; i <= n; i++) {
            for (j = 0; j <= n - i; j++) {
                int k = j + n - 1;
                for (int m = j; m <= k; m++) {
                    System.out.println(chararr);
                }
            }
        }

    }
}

