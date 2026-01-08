// Last updated: 1/8/2026, 6:44:16 PM
1class Solution {
2
3    public int minZeroArray(int[] nums, int[][] queries) {
4        int lo = 0, hi = queries.length, ans = -1;
5
6        while (lo <= hi) {
7            int mid = (lo + hi) / 2;
8            if (canZero(nums, queries, mid)) {
9                ans = mid;
10                hi = mid - 1;
11            } else {
12                lo = mid + 1;
13            }
14        }
15        return ans;
16    }
17
18    private boolean canZero(int[] nums, int[][] queries, int k) {
19        int n = nums.length;
20
21        for (int i = 0; i < n; i++) {
22            int target = nums[i];
23            if (target == 0) continue;
24
25            boolean[] dp = new boolean[target + 1];
26            dp[0] = true;
27
28            for (int j = 0; j < k; j++) {
29                int l = queries[j][0];
30                int r = queries[j][1];
31                int val = queries[j][2];
32
33                if (l <= i && i <= r) {
34                    for (int s = target; s >= val; s--) {
35                        dp[s] |= dp[s - val];
36                    }
37                }
38            }
39
40            if (!dp[target]) return false;
41        }
42        return true;
43    }
44}
45