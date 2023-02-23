package Winter2022;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(10));

    }

    static long getFactorial(long num) {
        long res = 1;
        while (num >= 2) {
            long temp = num * (num - 1);
            res *= temp;
            num -= 2;
        }
        return res;
    }
}
