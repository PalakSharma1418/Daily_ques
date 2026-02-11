// Last updated: 2/11/2026, 7:20:45 AM
class Solution {
    int INF = Integer.MAX_VALUE;
    public int minCost(int[][] grid, int k) {

        int m = grid.length;        
        int n = grid[0].length;    
        int MAXV = 10000;

        int[][][] dp = new int[k + 1][m][n];
        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[t][i], INF);
            }
        }

        int[] prefixMin = new int[MAXV + 1];
        Arrays.fill(prefixMin, INF);

        for (int t = 0; t <= k; t++) {
            int[] currMin = new int[MAXV + 1];
            Arrays.fill(currMin, INF);

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    if (i == m - 1 && j == n - 1) {
                        dp[t][i][j] = 0;
                    } else {

                        int ans = INF;
                        // down
                        if (i + 1 < m) {
                            ans = Math.min(ans,
                                    grid[i + 1][j] + dp[t][i + 1][j]);
                        }
                        // right
                        if (j + 1 < n) {
                            ans = Math.min(ans,
                                    grid[i][j + 1] + dp[t][i][j + 1]);
                        }
                        // teleport
                        if (t > 0) {
                            ans = Math.min(ans, prefixMin[grid[i][j]]);
                        }

                        dp[t][i][j] = ans;
                    }

                    currMin[grid[i][j]] =
                            Math.min(currMin[grid[i][j]], dp[t][i][j]);
                }
            }

            Arrays.fill(prefixMin, INF);
            prefixMin[0] = currMin[0];

            for (int v = 1; v <= MAXV; v++) {
                prefixMin[v] = Math.min(prefixMin[v - 1], currMin[v]);
            }
        }

        return dp[k][0][0];
    }
}