// Last updated: 1/24/2026, 2:42:29 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);
4        int i=0;
5        int j=nums.length-1;
6        int mx=0;
7        while(i<j){
8            int sum=nums[i]+nums[j];
9            mx=Math.max(mx,sum);
10            i++;
11            j--;
12        }
13        return mx;
14    }
15}