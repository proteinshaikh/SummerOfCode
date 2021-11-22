package Algorithms.problems;

public class Matrix {
    public static void main(String[] args) {
        printMatrix(3);

    }

    static void printMatrix(int n) {
        int i;
        int j;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print("0" + "  ");
                } else if (j > i) {
                    System.out.print("1" + "  ");
                } else {
                    System.out.print("-1" + " ");
                }
            }
            System.out.println();
        }
    }
}
