package Winter2022.h;

import java.util.*;


//most efficient way
public class CommonElements {

    static List<Integer> getCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int k : arr1) {
            set1.add(k);
        }

        List<Integer> list = new ArrayList<>();
        for (int j : arr2) {
            if (set1.contains(j)) {
                list.add(j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> res = getCommonElements((new int[]{1, 2, 3, 4}), (new int[]{1, 2, 3, 4, 6}));
        for (int a : res) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
