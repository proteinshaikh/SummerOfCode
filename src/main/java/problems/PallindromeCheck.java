package problems;

// check if a number is pallindrome or not
public class PallindromeCheck {
    public static void main(String[] args) {
        System.out.println(isPallindrome(12321));
    }

    private static boolean isPallindrome(int num) {
        boolean isPallindrome = false;
        int origNum = num;
        int tempNum = num;

        int counter = 0;
        while (tempNum != 0) {
            tempNum /= 10;
            if (tempNum != 0) {
                counter++;
            }
        }
        if (counter != 0) {
            counter++;
        }

        int sum = 0;
        while (num != 0) {
            int mod = num % 10;
            sum += mod * Math.pow(10, counter - 1);
            num /= 10;
            counter--;
        }
        if (sum == origNum) {
            isPallindrome = true;
        }
        return isPallindrome;
    }
}
