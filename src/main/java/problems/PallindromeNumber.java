package problems;

public class PallindromeNumber {
    public static void main(String[] args) {
        int[] num = {212, 111, 31, 200, 0000};
        int len = num.length-1;
        for (int i = 0; i <= len; i++) {
            int temp = num[i];

            int rem;
            int sum = 0;
            while (num[i] > 0) {
                rem = num[i] % 10;
                sum = (sum * 10) + rem;
                num[i] = num[i] / 10;

            }

            if (sum == temp) {
                System.out.println("number " + temp + " is pallindrome");
            } else {
                System.out.println("number " + temp + " is not pallindrome");
            }
        }


    }


}
