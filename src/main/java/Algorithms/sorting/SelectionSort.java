package Algorithms.sorting;

public class SelectionSort {

	public static void main(String... args) {
		int[] arr = { 4, 8, 1, 9 };

		for (int i = 0; i < arr.length - 1; i++) {
			int min_indx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_indx]) {
					min_indx = j;

					// swap
					int temp = arr[min_indx];
					arr[min_indx] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
