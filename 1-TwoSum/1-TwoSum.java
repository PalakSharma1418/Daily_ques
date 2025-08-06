// Last updated: 8/6/2025, 4:51:50 PM
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
             for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                   int [] a={i,j};
                   return a;
                }
             }
        }
        return new int[0];
}
}