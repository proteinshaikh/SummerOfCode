package Winter2022.h;

import java.util.HashMap;
import java.util.Map;

public class MostCommonElement {
    public static void main(String[] args) {
        System.out.println(getMostCommon(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5}));
    }

    static int getMostCommon(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int maxCount = 1;
        int mostCommon = arr[0];


        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > maxCount) {
                maxCount = m.getValue();
                mostCommon = m.getKey();
            }
        }
        return mostCommon;


    }
}
