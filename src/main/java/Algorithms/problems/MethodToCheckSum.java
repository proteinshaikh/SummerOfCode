package Algorithms.problems;

public class MethodToCheckSum {
    public static void main(String[] args) {
        checkSum(4, 5);

    }

    static void checkSum(int num1, int num2) {

        int check;

        int result = num1 + num2;
        if (result < 100) {
            check = 0;
            System.out.println(result + " is less than 100. Check value is " + check);
        } else if (result > 100) {
            check = 1;
            System.out.println(result + " is greater than 100. Check value is " + check);
        } else {
            check = 2;
            System.out.println(result + " is equal to 100. Check value is " + check);
        }

    }
}
