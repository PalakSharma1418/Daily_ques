// Last updated: 8/6/2025, 4:45:52 PM
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int row = 0; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }
        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }
        
        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        int m = mat.length, n = mat[0].length;
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col;
        while (r < m && c < n) {
            diagonal.add(mat[r][c]);
            r++;
            c++;
        }
        Collections.sort(diagonal);
        r = row;
        c = col;
        for (int val : diagonal) {
            mat[r][c] = val;
            r++;
            c++;
        }
    }
}
