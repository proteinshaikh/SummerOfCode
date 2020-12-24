package Leetcode;

 public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int sum=0;
       int res[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    sum=nums[i]+nums[j];
                    if(sum==target) {
                           res[0]=j;
                        res[1]=i;
       
                    }
                }
            }
        }
         return res;
    }
}
