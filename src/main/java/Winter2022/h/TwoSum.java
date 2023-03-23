package Winter2022.h;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] res = getTwoSum(new int[]{1, 2, 3, 4, 5}, 9);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }


    static int[] getTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }
}
