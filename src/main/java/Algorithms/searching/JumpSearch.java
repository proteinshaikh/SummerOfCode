package Algorithms.searching;

/*
 * Like Binary Search, Jump Search is a searching algorithm for sorted arrays.
 * The basic idea is to check fewer elements (than linear search) by jumping ahead by fixed steps or
 * skipping some elements in place of searching all elements.
 *
 * */
public class JumpSearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};

        int x = 13;

        int index = jumpSearch(arr, x);

        System.out.println("\nNumber " + x + " is at index " + index);
    }

    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;

        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        while ((arr[Math.min(step, n) - 1] < x)) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        while ((arr[prev] < x)) {
            prev++;

            if (prev == Math.min(step, n))
                return -1;
        }

        while (arr[prev] == x) {
            return prev;

        }
        return -1;
    }
}
