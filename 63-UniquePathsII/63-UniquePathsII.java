// Last updated: 9/28/2025, 2:37:58 PM
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int dp[][]= new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return pp(0,0,m,n,dp,obstacleGrid);
    }
    public int pp(int cr,int cc, int r, int c,int[][] dp,int [][]arr){
        if(cr>=r || cc >=c){
            return 0;
        }
        if(arr[cr][cc]==1){
            return 0;
        }
        
        if(cr==r-1 && cc==c-1){
            return 1;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int a = pp(cr+1,cc,r,c,dp,arr);
        int b= pp(cr,cc+1,r,c,dp,arr);
        return dp[cr][cc]= a+b; 
    }
}