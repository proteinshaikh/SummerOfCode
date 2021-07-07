package dojo;

// find nth index of fibonacci sequence
public class FibonacciSequence {

    public static void main(String[] args) {
        int m = 10;
        System.out.println(fibo(m));
        // 0 1 1 2 3 5 8 13 21 34 55
    }

    static int fibo(int n) {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }
}
