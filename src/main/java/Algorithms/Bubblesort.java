package Algorithms;
/*
 * In bubble sort algorithm, array is traversed from first element to last element. Here,
 * current element is compared with the next element. If current element is greater than the next element,
 * it is swapped.
 *
 * */
public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 6};
        int n = arr.length;
        int temp, i, j;
        for (i = 0; i < n; i++) {
            for (j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("sorted array is : ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
