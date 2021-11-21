package Algorithms.problems;

public class SumOfDig {
    public static void main(String[] args) {
        System.out.println(sumOfDig(786));

    }

    static int sumOfDig(int num) {
        int sum = 0;

        while (num > 0) {
            int mod = num % 10;
            num = num / 10;
            sum += mod;
        }
        return sum;
    }
}
