// Last updated: 8/6/2025, 4:50:51 PM
class Solution {
    public List<List<String>> solveNQueens(int n) {
         boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        solve(board, 0, n, result);
        return result;
    }
        public static void solve(boolean[][] board, int row, int tq, List<List<String>> result) {
        if (tq == 0) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isitsafe(board, row, col)) {
                board[row][col] = true;
                solve(board, row + 1, tq - 1, result);
                board[row][col] = false; // Backtrack
            }
        }
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
        public static List<String> construct(boolean[][] board) {
        List<String> solution = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean cell : row) {
                sb.append(cell ? 'Q' : '.');
            }
            solution.add(sb.toString());
        }
        return solution;
    }
}