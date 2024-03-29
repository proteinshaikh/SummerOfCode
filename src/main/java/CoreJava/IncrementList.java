package CoreJava;

import java.util.Arrays;
import java.util.List;

public class IncrementList {
    public static void main(String[] args) {
        getIncrementedList(Arrays.asList(1, 2, 3, 4, 5));

    }

    static void getIncrementedList(List<Integer> list) {

        System.out.println("List Before increment: ");

        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(" ");
        }
        System.out.println("\n");
        System.out.println("List After increment: ");

        for (Integer integer : list) {
            System.out.print(integer + 1);
            System.out.print(" ");
        }
    }
}
