// Last updated: 12/11/2025, 7:34:47 AM
class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // memo[i][j][rem]
        Integer[][][] memo = new Integer[m][n][k];

        return dfs(0, 0, 0, grid, m, n, k, memo);
    }

    private int dfs(int i, int j, int rem, int[][] grid, int m, int n, int k, Integer[][][] memo) {

        if (i >= m || j >= n) return 0;  // Out of bounds

        int newRem = (rem + grid[i][j]) % k;

        // Base case: reached bottom-right
        if (i == m - 1 && j == n - 1) {
            return newRem == 0 ? 1 : 0;
        }

        if (memo[i][j][rem] != null) {
            return memo[i][j][rem];
        }

        long ways = 0;

        // Move RIGHT
        ways += dfs(i, j + 1, newRem, grid, m, n, k, memo);

        // Move DOWN
        ways += dfs(i + 1, j, newRem, grid, m, n, k, memo);

        memo[i][j][rem] = (int)(ways % MOD);

        return memo[i][j][rem];
    }
}
