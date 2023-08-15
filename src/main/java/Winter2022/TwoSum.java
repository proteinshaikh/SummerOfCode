package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(twosum(new int[]{1, 2, 3, 4, 5}, 3));

    }

    static int[] twosum(int[] nums, int target) throws IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum found");
    }
}
