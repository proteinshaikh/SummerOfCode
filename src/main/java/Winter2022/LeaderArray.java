package Winter2022;

/*A leader in an array is an element that is larger than all elements to its right*/
public class LeaderArray {
    public static void main(String[] args) {

        System.out.println(findleader(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3}));

    }

    static int findleader(int[] arr) {
        int candidate = 0;
        int count = 0;

        //find the candidate for the leader
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;

            } else if (arr[i] == candidate) {
                count++;

            } else {
                count--;
            }
        }

        //verify that candidate is actually the leader
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}


