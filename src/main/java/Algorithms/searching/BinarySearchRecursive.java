package Algorithms.searching;
//test comment
//Search a sorted array by repeatedly dividing the search interval in half.
public class BinarySearchRecursive {
	public static void main(String[] args) {
		
		int[] array= {10,20,30,40,50,60};
		binarySearchRecursiveMethod(array, 99, 0, 5);
	}
	
	public static boolean binarySearchRecursiveMethod(int[] array, int x, int left, int right) {
		if(left > right) {
			System.out.println(x+" not found");
			return false;
			
		}
		int mid = (left+right)/2;
		if(x == array[mid]) {
			System.out.println(x +" found at index "+mid);
			return true;
			
		}else if(x < array[mid]) {
			return binarySearchRecursiveMethod(array, x, left, mid-1);
		}else return binarySearchRecursiveMethod(array, x, mid+1, right);
	}

}
