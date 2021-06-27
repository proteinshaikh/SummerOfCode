package Algorithms.searching;

/*
*
* Interpolation search is an improved variant of binary search.
* This search algorithm works on the probing position of the required value.
* For this algorithm to work properly, the data collection should be in a sorted form and equally distributed.

Binary search has a huge advantage of time complexity over linear search.
* Linear search has worst-case complexity of Ο(n) whereas binary search has Ο(log n).

There are cases where the location of target data may be known in advance.
* For example, in case of a telephone directory, if we want to search the telephone number of Morphius.
* Here, linear search and even binary search will seem slow as we can directly jump to memory space
* where the names start from 'M' are stored.
* */

public class InterpolationSearch {

    public static void main(String[] args) {

        int arr[] = {10, 12, 13, 16, 18, 19, 20, 21,
                22, 23, 24, 33, 35, 42, 47};

        int n = arr.length;

        int x = 18;

        int index = interpolationSearch(arr, 0, n - 1, x);

        if (index != -1)
            System.out.println("element found at index: " + index);
        else System.out.println("element not found");

    }

    public static int interpolationSearch(int arr[], int lo, int hi, int x) {

        int pos;
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

            pos = lo
                    + (((hi - lo) / (arr[hi] - arr[lo]))
                    * (x - arr[lo]));

            if (arr[pos] == x)
                return pos;

            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi, x);

            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1, x);
        }
        return -1;

    }


}
