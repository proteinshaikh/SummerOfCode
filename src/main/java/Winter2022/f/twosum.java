package Winter2022.f;

import java.util.HashMap;
import java.util.Map;

public class twosum {

    public static void main(String[] args) {
        int[] ints = twosum(new int[]{1, 2, 3, 4, 5}, 7);
        for (int a : ints) {
            System.out.print(a + " ");

        }
    }

    static int[] twosum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }
}
