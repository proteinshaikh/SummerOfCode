package Winter2022;


/*Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=2
Output: 5 6 7 1 2 3 4*/
public class RotateArray {
    public static void main(String[] args) {
        int[] res = rotateArr(2, new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    static int[] rotateArr(int d, int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[(i + d) % n];
        }
        return temp;
    }

}
