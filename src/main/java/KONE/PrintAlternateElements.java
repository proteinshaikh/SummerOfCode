package KONE;

import java.util.Arrays;
import java.util.List;

public class PrintAlternateElements {

    /*a=1,3,4,6
    b=7,9,2
    a=1,7,3,9,4,2,6
    b=empty*/
    public static void main(String[] args) {

        List<Integer> listA = Arrays.asList(1, 3, 4, 6);
        List<Integer> listB = Arrays.asList(7, 9, 2, 7, 9, 0, 1, 2, 3);

        printAlternate(listA, listB);
    }

    private static void printAlternate(List<Integer> listA, List<Integer> listB) {
        int i = 0;
        while (i < listA.size() && i < listB.size()) {
            if (i < listA.size()) {
                System.out.println(listA.get(i));
                if (i < listB.size()) {
                    System.out.println(listB.get(i));
                }
            }
            i++;
        }
        listB = null;
        System.out.println("listB = " + listB);
    }
}

