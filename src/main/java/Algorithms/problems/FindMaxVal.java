package Algorithms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMaxVal {
    public static void main(String[] args) {

        System.out.println(findMaxVal(Arrays.asList(1, 2, 3, 4, 5, 6)));

    }

    static int findMaxVal(List<Integer> list) {
        return Collections.max(list);
    }
}
