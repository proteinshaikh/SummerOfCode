package Winter2022.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        for (int a : getIndexes(new int[]{1, 2, 3, 4, 5, 6}, 11)) {
            System.out.print(a + " ");
        }
    }

    static int[] getIndexes(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = sum - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};

            }
            map.put(arr[i], i);
        }
        return null;
    }
}
