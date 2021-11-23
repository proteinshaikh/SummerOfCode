package Algorithms.problems;

import CoreJava.Collections;
import Java8.StreamOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZerosToStart {
    public static void main(String[] args) {
        System.out.println(zerosToStart(Arrays.asList(0, 2, 5, 0, 2, 6, 0, 0, 8)));

    }

    static List<Integer> zerosToStart(List<Integer> list) {
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                zeroList.add(list.get(i));
            } else {
                numList.add(list.get(i));
            }
        }
        return Stream.of(zeroList, numList).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
