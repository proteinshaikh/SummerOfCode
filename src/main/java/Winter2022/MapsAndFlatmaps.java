package Winter2022;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapsAndFlatmaps {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> res = list.stream().map(x -> x * x).collect(Collectors.toList());
        for (int a : res) {
            System.out.print(a + " ");
        }

        System.out.println();

        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9));

        List<Integer> flatlist = lists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        for (int a : flatlist) {
            System.out.print(a + " ");
        }
    }
}
