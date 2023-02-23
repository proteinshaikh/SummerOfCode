package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int target = 3;
        int[] res = getTwoSum(arr, target);
        for(int s: res){
            System.out.print(s + " ");
        }

    }

    static int[] getTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int res = target - arr[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            } else {
                map.put(arr[i], i);
            }
        }
        throw new IllegalArgumentException("two sum not found");
    }
}
