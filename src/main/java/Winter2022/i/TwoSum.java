package Winter2022.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {
    public static void main(String[] args) {
        for (int a : Objects.requireNonNull(getIndexes(new int[]{1, 2, 3, 4, 5, 6}))) {
            System.out.print(a + " ");
        }
    }

    static int[] getIndexes(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = 11 - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};

            }
            map.put(arr[i], i);
        }
        return null;
    }
}
