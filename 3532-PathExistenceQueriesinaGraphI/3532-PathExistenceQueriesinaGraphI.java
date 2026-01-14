// Last updated: 1/14/2026, 12:34:12 PM
1class Solution {
2    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        boolean[] ans = new boolean[queries.length];
4        int[] prefix = new int[n];
5        for (int i = 1; i < n; i++) {
6            int d = nums[i] - nums[i - 1];
7            if (d < 0) d = -d;
8            prefix[i] = prefix[i - 1] + (d > maxDiff ? 1 : 0);
9        }
10
11        for (int i = 0; i < queries.length; i++) {
12            int u = queries[i][0];
13            int v = queries[i][1];
14            int start = Math.min(u, v);
15            int end = Math.max(u, v);
16            ans[i] = (prefix[end] - prefix[start] == 0);
17        }
18
19        return ans;
20    }
21}
22