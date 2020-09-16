package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 10};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(30);
        Collections.sort(list);
        System.out.println(list);
    }
}
