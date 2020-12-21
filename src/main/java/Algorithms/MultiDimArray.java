package Algorithms;

public class MultiDimArray {
	public static void main(String[] args) {
		int arr[][] = new int[3][3];
		arr[0][0] = 45;
		arr[0][1] = 45;
		arr[0][2] = 45;
		arr[1][0] = 45;
		arr[1][1] = 45;
		arr[1][2] = 3;
		arr[2][0] = 34;
		arr[2][1] = 25;
		arr[2][2] = 4;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------");
		int arr2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr2[i][j] + " ");

			}
			System.out.println();

		}
	}
}
