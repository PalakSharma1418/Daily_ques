// Last updated: 10/18/2025, 5:59:08 PM
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Step 1: Mark all 'O's connected to borders as 'T'
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);//left bla
            dfs(board, i, m - 1);//right vala
        }
        for (int j = 0; j < m; j++) {
            dfs(board, 0, j);//top
            dfs(board, n - 1, j);//bottom
        }

        // Step 2 & 3: Flip 'O' -> 'X' and 'T' -> 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') return;

        board[i][j] = 'T'; // Mark as safe

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
