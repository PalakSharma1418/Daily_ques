// Last updated: 11/27/2025, 12:16:27 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int n=nums.length;
4        int xor =0;
5        for(int i=0;i<n;i++){
6            xor=xor^nums[i];
7            // xor=xor^(i+1);
8        }
9        // xor=xor^(n+1);
10        return xor;
11    }
12}
13// xor le lo 