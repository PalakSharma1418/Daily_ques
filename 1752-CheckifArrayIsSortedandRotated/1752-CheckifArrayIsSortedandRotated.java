// Last updated: 5/23/2026, 7:28:34 PM
1class Solution {
2    public boolean check(int[] nums) {
3        int n= nums.length;
4        int b=0;
5        for(int i=1;i<n;i++){
6            if(nums[i-1]>nums[i]){
7                b++;
8            }
9        }
10        if(nums[0]<nums[n-1]){
11            b++;
12        }
13        return b<=1;
14    }
15}