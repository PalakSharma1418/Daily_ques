// Last updated: 11/26/2025, 7:56:31 PM
1class Solution {
2    static final int MOD = 1_000_000_007;
3
4    public int numberOfPaths(int[][] grid, int k) {
5        int m = grid.length;
6        int n = grid[0].length;
7
8        // memo[i][j][rem]
9        Integer[][][] memo = new Integer[m][n][k];
10
11        return dfs(0, 0, 0, grid, m, n, k, memo);
12    }
13
14    private int dfs(int i, int j, int rem, int[][] grid, int m, int n, int k, Integer[][][] memo) {
15
16        if (i >= m || j >= n) return 0;  // Out of bounds
17
18        int newRem = (rem + grid[i][j]) % k;
19
20        // Base case: reached bottom-right
21        if (i == m - 1 && j == n - 1) {
22            return newRem == 0 ? 1 : 0;
23        }
24
25        if (memo[i][j][rem] != null) {
26            return memo[i][j][rem];
27        }
28
29        long ways = 0;
30
31        // Move RIGHT
32        ways += dfs(i, j + 1, newRem, grid, m, n, k, memo);
33
34        // Move DOWN
35        ways += dfs(i + 1, j, newRem, grid, m, n, k, memo);
36
37        memo[i][j][rem] = (int)(ways % MOD);
38
39        return memo[i][j][rem];
40    }
41}
42