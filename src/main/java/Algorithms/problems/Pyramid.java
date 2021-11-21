package Algorithms.problems;

public class Pyramid {
    public static void main(String[] args) {
        getPyramid(8);
    }

    static void getPyramid(int numOfLayers) {
        System.out.println("number of rows= " + numOfLayers);

        for (int i = 1; i <= numOfLayers; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
