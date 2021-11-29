package CoreJava;

import java.util.Arrays;

public class ArraysSample {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4,};

        System.out.println("original length of array = " + ints.length);
        int[] ints2 = Arrays.copyOf(ints, 10);

        System.out.println("New length of array = " + ints2.length);
        int i = 0;
        while (i < ints.length) {
            System.out.print(ints[i] + " ");
            i++;
        }


    }
}
