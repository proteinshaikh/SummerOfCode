package Winter2022;

public class DivisibleBy3 {//no mod or division operator

    public static void main(String[] args) {

        isDivisibleByThree(9);

    }

    static void isDivisibleByThree(int num) {
        while (num >= 0) {
            num -= 3;
            if (num == 0) {
                System.out.println("num is divisible by 3");
                break;
            } else if (num < 3) {
                System.out.println("num is not divisible by 3");
                break;
            }
        }
    }
}
