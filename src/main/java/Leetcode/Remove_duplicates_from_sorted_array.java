package Leetcode;

public class Remove_duplicates_from_sorted_array {

    public static void main(String[] args) {
        int[] ints = {1,1,2,2,3,3,4,4};
        System.out.println(removeDuplicates(ints));

    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
