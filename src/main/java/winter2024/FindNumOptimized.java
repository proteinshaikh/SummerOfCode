package winter2024;

public class FindNumOptimized {

    public static void main(String[] args) {
        System.out.println(findNum(new int[]{0, 10, 20, 30, 40, 50}, 30));
    }

    static boolean findNum(int[] arr, int target) {
        return binarySearch(arr, target);
    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Using a more optimized approach for calculating the midpoint
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

