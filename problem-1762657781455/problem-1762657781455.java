// Last updated: 11/9/2025, 8:39:41 AM
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int q = k;
        int[][][] dp = new int [m][n][k+1];
        for(int [][] l : dp){
            for(int[] r : l){
                Arrays.fill(r,-2);
            }
        }
        int ans=dfs(grid,0,0,0,k,dp);
        return ans<0?-1:ans ;
    }

    public int dfs(int[][] grid , int r ,  int c , int cost , int k, int[][][]dp){
        int m = grid.length;
         int n =grid[0].length;
        if(r>=m || c>=n ) return -1;

        int val =grid[r][c];
        int s = (val==0?0:(val==1?1:2));
        int ac=(val==0?0:1);
        int nc= cost+ac;

        if(nc>k) return -1;
        if(r==m-1 && c==n-1) return s;

        if(dp[r][c][nc] !=-2) return dp[r][c][nc];

        int ri = dfs(grid , r,c+1,nc,k,dp);
        int d = dfs(grid , r+1 , c ,nc ,k,dp);
        int b=Math.max(ri,d);
        if(b==-1){
            return dp[r][c][nc]=-1;
        }
        return dp[r][c][nc]=s+b;
    }
}