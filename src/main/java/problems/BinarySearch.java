package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 10};
        int res = Arrays.binarySearch(arr, 10);
        System.out.println("10 is found at index: " + res);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(30);
        int rescoll = Collections.binarySearch(list, 7);
        System.out.println("zeeshan is on index : " + rescoll);

    }
}
