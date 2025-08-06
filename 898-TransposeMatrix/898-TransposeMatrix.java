// Last updated: 8/6/2025, 4:46:44 PM
class Solution {
    public int[][] transpose(int[][] matrix) {
        int r1= matrix.length;
        int c1= matrix[0].length;
        int [][] m= new int[c1][r1];
        for(int r2=0;r2<c1;r2++){
            for(int c2=0;c2<r1;c2++){
                m[r2][c2]=matrix[c2][r2];
            }
        }
        return m;
    }
}