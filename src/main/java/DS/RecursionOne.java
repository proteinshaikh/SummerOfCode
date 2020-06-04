package DS;

public class RecursionOne {

    public static void main(String[] args) {
        RecursionOne rone = new RecursionOne();
        System.out.println(rone.factorial(12));
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else
            return n * factorial(n - 1);

    }

}
