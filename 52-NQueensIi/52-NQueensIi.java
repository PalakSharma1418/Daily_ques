// Last updated: 8/6/2025, 4:50:50 PM
class Solution {
    public int totalNQueens(int n) {
         boolean[][] board = new boolean[n][n];
        return solve(board, 0, n);
    }
    public static int solve(boolean[][] board, int row, int tq) {
        if (tq == 0) {
            return 1;
        }
        int t=0;
        for (int col = 0; col < board[0].length; col++) {
            if (isitsafe(board, row, col)) {
                board[row][col] = true;
                t+=solve(board, row + 1, tq - 1);
                board[row][col] = false; // Backtrack
            }
        }
        return t;
    }
    public static boolean isitsafe(boolean[][] board, int row, int col) {
        // Check column
        for (int r = row; r >= 0; r--) {
            if (board[r][col]) return false;
        }

        // Check left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        // Check right diagonal
        for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c]) return false;
        }

        return true;
    }
}
