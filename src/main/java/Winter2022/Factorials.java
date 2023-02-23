package Winter2022;

public class Factorials {
    public static void main(String[] args) {
        System.out.println(factorial(7));

    }

    static int factorial(int num) {
        if (num <= 0) return 1;
        return num * factorial(num - 1);
    }
}
