// Last updated: 1/7/2026, 4:48:20 PM
1class Solution {
2    int n;
3    public boolean validPartition(int[] nums) {
4        n = nums.length;
5        Boolean[] dp = new Boolean[n];
6        return helper(0,nums,dp);
7    }
8    public boolean helper(int idx, int[] nums, Boolean[] dp){
9        if(idx >= n){
10            return true;
11        }
12        if(dp[idx] != null){
13            return dp[idx];
14        }
15        boolean res = false;
16        if(idx < n-1 && nums[idx] == nums[idx+1]){
17            res |= helper(idx+2,nums,dp);
18        }
19        if(idx < n-2 && nums[idx] == nums[idx+1] && nums[idx] == nums[idx+2]){
20            res |= helper(idx+3, nums, dp);
21        }
22        if(idx < n-2 && nums[idx] == nums[idx+1]-1 && nums[idx] == nums[idx+2]-2){
23            res |= helper(idx+3, nums,dp);
24        }
25        return dp[idx] = res;
26    }
27}