// Last updated: 4/30/2026, 5:54:47 PM
1class Solution {
2    public int maxPathScore(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int q = k;
6        int[][][] dp = new int [m][n][k+1];
7        for(int [][] l : dp){
8            for(int[] r : l){
9                Arrays.fill(r,-2);
10            }
11        }
12        int ans=dfs(grid,0,0,0,k,dp);
13        return ans<0?-1:ans ;
14    }
15
16    public int dfs(int[][] grid , int r ,  int c , int cost , int k, int[][][]dp){
17        int m = grid.length;
18         int n =grid[0].length;
19        if(r>=m || c>=n ) return -1;
20
21        int val =grid[r][c];
22        int s = (val==0?0:(val==1?1:2));
23        int ac=(val==0?0:1);
24        int nc= cost+ac;
25
26        if(nc>k) return -1;
27        if(r==m-1 && c==n-1) return s;
28
29        if(dp[r][c][nc] !=-2) return dp[r][c][nc];
30
31        int ri = dfs(grid , r,c+1,nc,k,dp);
32        int d = dfs(grid , r+1 , c ,nc ,k,dp);
33        int b=Math.max(ri,d);
34        if(b==-1){
35            return dp[r][c][nc]=-1;
36        }
37        return dp[r][c][nc]=s+b;
38    }
39}