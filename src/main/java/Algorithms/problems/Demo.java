package Algorithms.problems;

public class Demo {
    public static void main(String[] args) {
        int result, x;
        x = 1;
        result = 0;
        while (x <= 10) {
            if (x % 2 == 0)
                result += 10;
            ++x;
        }
        System.out.println(result);
        System.out.println(2%3);

    }
}
