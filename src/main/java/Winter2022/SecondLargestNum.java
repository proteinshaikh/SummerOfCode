package Winter2022;

public class SecondLargestNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,};
        System.out.println(findSecondLargest(arr));

    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secLargest = largest;
                largest = num;
            } else if (num > secLargest && num != largest) {
                secLargest = num;

            }
        }
        return secLargest;
    }
}
