// Last updated: 5/10/2026, 10:15:59 AM
1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        
4        int n = nums.length;
5
6        int[] dp = new int[n];
7
8        Arrays.fill(dp, -1);
9
10        // base case
11        dp[0] = 0;
12
13        for(int i = 0; i < n; i++) {
14
15            // unreachable index
16            if(dp[i] == -1) continue;
17
18            for(int j = i + 1; j < n; j++) {
19
20                long diff = 1L * nums[j] - nums[i];
21
22                if(-target <= diff && diff <= target) {
23
24                    dp[j] = Math.max(dp[j], dp[i] + 1);
25                }
26            }
27        }
28
29        return dp[n - 1];
30    }
31}