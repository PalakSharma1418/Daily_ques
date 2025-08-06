// Last updated: 8/6/2025, 4:42:45 PM
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int []onerow= new int[n];
        int []onecol= new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                onerow[i] += grid[i][j];
                onecol[j] += grid[i][j];
            }
        }
        int [][] res= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=onerow[i]+onecol[j]-(n-onerow[i])-(m-onecol[j]);
            }
        }
        return res;
    }
}