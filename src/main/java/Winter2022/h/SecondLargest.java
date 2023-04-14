package Winter2022.h;

public class SecondLargest {
    public static void main(String[] args) {
        System.out.println(getSecondLargestNum(new int[]{6, 3, 9, 6, 11, 2, 6, 3}));
    }

    static int getSecondLargestNum(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secLargest && arr[i] != largest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}
