
package Winter2022;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getfibonacci(5));

    }

    static int getfibonacci(int n) {
        if (n <= 0 || n == 1) {
            return 1;
        }// 0 1 1 2 3 5 8 13 ..
        else {
            return getfibonacci(n - 2) + getfibonacci(n - 1);
        }

    }
}

