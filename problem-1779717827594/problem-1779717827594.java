// Last updated: 5/25/2026, 7:33:47 PM
1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3
4        int n = s.length();
5
6        boolean[] dp = new boolean[n];
7        dp[0] = true;
8
9        int reachable = 0;
10
11        for (int i = 1; i < n; i++) {
12
13            // Add new reachable position
14            if (i - minJump >= 0 && dp[i - minJump]) {
15                reachable++;
16            }
17
18            // Remove out of window position
19            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
20                reachable--;
21            }
22
23            // Current index can be reached
24            if (reachable > 0 && s.charAt(i) == '0') {
25                dp[i] = true;
26            }
27        }
28
29        return dp[n - 1];
30    }
31}