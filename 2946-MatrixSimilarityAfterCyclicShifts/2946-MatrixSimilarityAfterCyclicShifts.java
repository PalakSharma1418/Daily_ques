// Last updated: 10/3/2025, 7:18:32 AM
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != mat[i][(j+k) % n])
                    return false;
            }
        }
        return true;
    }
}