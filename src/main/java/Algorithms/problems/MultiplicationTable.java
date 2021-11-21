package Algorithms.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println(getTable(5));
    }

    private static String getTable(int num) {
        int i = 1;
        List<Integer> list = new ArrayList<>();

        while (i <= 10) {
            int result = num * i;
            list.add(result);
            i++;

        }

        return list.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
