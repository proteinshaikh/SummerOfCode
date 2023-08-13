package Winter2022.d;

public class FindNumOptimized {//works for sorted arrays only
    public static void main(String[] args) {
        System.out.println(findNum(new int[]{0, 10, 20, 30, 40, 50}, 30));
    }

    static boolean findNum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}

