package CoreJava;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListsIntersection {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);
        System.out.println(getCommonElementsFromLists(list1, list2));

    }

    //using java 8
    static List<Integer> getCommonElementsFromLists(List<Integer> list1, List<Integer> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }


}
