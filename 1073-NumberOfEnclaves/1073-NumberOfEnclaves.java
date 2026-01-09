// Last updated: 1/9/2026, 10:57:57 AM
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Top & Bottom borders
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j);
            if (grid[n - 1][j] == 1) dfs(grid, n - 1, j);
        }

        // Left & Right borders
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][m - 1] == 1) dfs(grid, i, m - 1);
        }

        int c=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) c++;
            }
        }
        return c;
    }

    private void dfs(int [][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 1)
            return;

        board[i][j] = 2;

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
