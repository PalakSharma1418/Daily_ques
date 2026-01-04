// Last updated: 1/4/2026, 5:37:59 AM
1class Solution {
2    public int numEnclaves(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        // Top & Bottom borders
7        for (int j = 0; j < m; j++) {
8            if (grid[0][j] == 1) dfs(grid, 0, j);
9            if (grid[n - 1][j] == 1) dfs(grid, n - 1, j);
10        }
11
12        // Left & Right borders
13        for (int i = 0; i < n; i++) {
14            if (grid[i][0] == 1) dfs(grid, i, 0);
15            if (grid[i][m - 1] == 1) dfs(grid, i, m - 1);
16        }
17
18        int c=0;
19        for (int i = 0; i < n; i++) {
20            for (int j = 0; j < m; j++) {
21                if (grid[i][j] == 1) c++;
22            }
23        }
24        return c;
25    }
26
27    private void dfs(int [][] board, int i, int j) {
28        int n = board.length;
29        int m = board[0].length;
30
31        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 1)
32            return;
33
34        board[i][j] = 2;
35
36        dfs(board, i + 1, j);
37        dfs(board, i - 1, j);
38        dfs(board, i, j + 1);
39        dfs(board, i, j - 1);
40    }
41}
42