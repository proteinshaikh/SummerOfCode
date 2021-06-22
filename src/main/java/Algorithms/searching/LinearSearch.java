package Algorithms.searching;

public class LinearSearch {
	public static void main(String[] args) {
		int arr[] = { 5, 7, 2, 4, 9 };
		boolean flag = false;
		int findThis = 10;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == findThis) {
				flag = true;
			}
		}
		System.out.println("Number found --> " + flag);
	}
}
