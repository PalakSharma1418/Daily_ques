// Last updated: 1/28/2026, 7:56:04 PM
1class Solution {
2    int INF = Integer.MAX_VALUE;
3    public int minCost(int[][] grid, int k) {
4
5        int m = grid.length;        
6        int n = grid[0].length;    
7        int MAXV = 10000;
8
9        int[][][] dp = new int[k + 1][m][n];
10        for (int t = 0; t <= k; t++) {
11            for (int i = 0; i < m; i++) {
12                Arrays.fill(dp[t][i], INF);
13            }
14        }
15
16        int[] prefixMin = new int[MAXV + 1];
17        Arrays.fill(prefixMin, INF);
18
19        for (int t = 0; t <= k; t++) {
20            int[] currMin = new int[MAXV + 1];
21            Arrays.fill(currMin, INF);
22
23            for (int i = m - 1; i >= 0; i--) {
24                for (int j = n - 1; j >= 0; j--) {
25
26                    if (i == m - 1 && j == n - 1) {
27                        dp[t][i][j] = 0;
28                    } else {
29
30                        int ans = INF;
31                        // down
32                        if (i + 1 < m) {
33                            ans = Math.min(ans,
34                                    grid[i + 1][j] + dp[t][i + 1][j]);
35                        }
36                        // right
37                        if (j + 1 < n) {
38                            ans = Math.min(ans,
39                                    grid[i][j + 1] + dp[t][i][j + 1]);
40                        }
41                        // teleport
42                        if (t > 0) {
43                            ans = Math.min(ans, prefixMin[grid[i][j]]);
44                        }
45
46                        dp[t][i][j] = ans;
47                    }
48
49                    currMin[grid[i][j]] =
50                            Math.min(currMin[grid[i][j]], dp[t][i][j]);
51                }
52            }
53
54            Arrays.fill(prefixMin, INF);
55            prefixMin[0] = currMin[0];
56
57            for (int v = 1; v <= MAXV; v++) {
58                prefixMin[v] = Math.min(prefixMin[v - 1], currMin[v]);
59            }
60        }
61
62        return dp[k][0][0];
63    }
64}