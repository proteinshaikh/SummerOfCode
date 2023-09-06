package Algorithms.searching;

/*
* problem:Given a sorted array, and an element x to be
searched, find position of x in the array.
* Exponential search involves two steps:
1. Find range where element is present
2. Do Binary Search in above found range.
*
* */

import java.util.Arrays;

public class ExponentialSearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;
        int result = exponentialSearch(arr, arr.length, x);

        System.out.println((result < 0) ? "element is not present in array" : "element is present in array " + result);
    }

    static int exponentialSearch(int[] arr, int n, int x) {
        if (arr[0] == x)
            return x;

        int i = 1;
        while (i < n && arr[i] <= x) i = i * 2;
        return Arrays.binarySearch(arr, i / 2, Math.min(i, n - 1), x);
    }

}
