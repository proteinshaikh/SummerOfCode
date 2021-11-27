package CoreJava;

public class PrimeNumFind {
    public static void main(String[] args) {
        System.out.println(isPrime(41));

    }

    static boolean isPrime(int num) {
        boolean flag = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
