// Last updated: 1/9/2026, 8:43:51 PM
1class Solution {
2    public int maximumLength(int[] nums, int k) {
3        int n = nums.length;
4        int[][] dp = new int[k][n];
5        for(int[] a : dp){
6            Arrays.fill(a,1);
7        }
8
9        int ans = 1;
10        for(int i = 0; i<n; i++){
11            for(int j = 0; j<i; j++){
12                int mod = (nums[i]+nums[j])%k;
13                dp[mod][i] = Math.max(dp[mod][i],dp[mod][j]+1);
14                ans = Math.max(ans,dp[mod][i]);
15            }
16        }
17        return ans;
18    }
19}