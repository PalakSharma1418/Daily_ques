// Last updated: 11/29/2025, 6:54:21 PM
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int sum=0;
4        for(int i=0;i<nums.length;i++){
5            sum+=nums[i];
6        }
7        int rem= sum%k;
8        if(rem==0){
9            return 0;
10        }
11        return rem;
12    }
13}