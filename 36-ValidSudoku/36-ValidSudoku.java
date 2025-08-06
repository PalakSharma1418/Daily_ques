// Last updated: 8/6/2025, 4:51:11 PM
class Solution {
    public boolean isValidSudoku(char[][] grid) {
        return check(grid, 0, 0);
    }

    public static boolean check(char[][] grid, int row, int col) {
        if (col == 9) { 
            row++;
            col = 0;
        }
        if (row == 9) { 
            return true; // Successfully checked all cells, board is valid
        }

        if (grid[row][col] != '.') {
            if (!isitsafe(grid, row, col, grid[row][col])) {
                return false; // Invalid placement found
            }
            return check(grid, row, col + 1); // Move to next cell
        } else {
            return check(grid, row, col + 1); // Skip empty cells
        }
    }

    public static boolean isitsafe(char[][] grid, int row, int col, char val) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (i != col && grid[row][i] == val) {
                return false; // Duplicate in the same row
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (i != row && grid[i][col] == val) {
                return false; // Duplicate in the same column
            }
        }

        // Check 3×3 box
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if ((i != row || j != col) && grid[i][j] == val) {
                    return false; // Duplicate in the 3x3 box
                }
            }
        }

        return true;
    }
}
