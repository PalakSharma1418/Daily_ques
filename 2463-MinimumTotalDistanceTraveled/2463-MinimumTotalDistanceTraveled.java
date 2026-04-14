// Last updated: 4/14/2026, 6:18:22 PM
1class Solution {
2    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
3        Collections.sort(robot);
4        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
5
6        int n = robot.size();
7        int m = factory.length;
8
9        long INF = (long)1e18;
10        long[][] dp = new long[n + 1][m + 1];
11
12        for (int i = 0; i <= n; i++)
13            Arrays.fill(dp[i], INF);
14
15        for (int j = 0; j <= m; j++)
16            dp[0][j] = 0;
17
18        for (int j = 1; j <= m; j++) {
19            int pos = factory[j - 1][0];
20            int limit = factory[j - 1][1];
21
22            for (int i = 0; i <= n; i++) {
23                dp[i][j] = dp[i][j - 1];
24
25                long dist = 0;
26                for (int k = 1; k <= limit && i - k >= 0; k++) {
27                    dist += Math.abs(robot.get(i - k) - pos);
28                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + dist);
29                }
30            }
31        }
32
33        return dp[n][m];
34    }
35}