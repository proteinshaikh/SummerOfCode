package problems;

/*
Java program to print 2nd highest number in an array
* */
public class SecondHighestNumInArray {
    public static void main(String[] args) {
        String str = "0123456789";
        char a[] = str.toCharArray();
        int nums[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            nums[i] = Character.getNumericValue(a[i]);
        }
        System.out.println(getNthHighestNum(nums, 2));

    }

    private static int getNthHighestNum(int nums[], int n) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return nums[n - 1];
    }
}
