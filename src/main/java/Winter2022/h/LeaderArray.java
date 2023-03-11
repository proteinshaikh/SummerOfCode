package Winter2022.h;

public class LeaderArray {
    public static void main(String[] args) {
        getLeaderArr(new int[]{16, 17, 4, 3, 5, 2});
    }

    static void getLeaderArr(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1]; //the right most element is the leader
        System.out.print(max + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                System.out.print(max + " ");
            }
        }
    }
}
