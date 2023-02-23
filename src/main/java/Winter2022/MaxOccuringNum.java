package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuringNum {
    public static void main(String[] args) {
        System.out.println(getMaxOccuringNum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}));

    }

    static int getMaxOccuringNum(int[] arr) {
        Map<Integer, Integer> freqmap = new HashMap<>();

        for (int num : arr) {
            freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);
        }

        int maxnum = Integer.MIN_VALUE;
        int maxcount = Integer.MIN_VALUE;

        for (int a : freqmap.keySet()) {
            int count = freqmap.get(a);
            if (count > maxcount) {
                maxcount = count;
                maxnum = a;
            }
        }
        return maxnum;
    }
}
