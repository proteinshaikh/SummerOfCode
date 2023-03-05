package Winter2022.h;

import java.util.*;


//most efficient way
public class CommonElements {

    static List<Integer> getCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                list.add(arr2[i]);
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
