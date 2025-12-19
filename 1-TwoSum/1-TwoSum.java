// Last updated: 12/19/2025, 9:20:27 PM
1class Solution {
2    public static int[] twoSum(int[] nums, int target) {
3        for(int i=0;i<nums.length;i++){
4             for(int j=i+1;j<nums.length;j++){
5                if(nums[i]+nums[j]==target){
6                   int [] a={i,j};
7                   return a;
8                }
9             }
10        }
11        return new int[0];
12}
13}