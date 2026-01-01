// Last updated: 1/1/2026, 12:13:59 PM
1class Solution {
2    static int ans=0;
3    public int maxAreaOfIsland(int[][] grid) {
4        ans=0;
5        int n=grid.length;
6        int m = grid[0].length;
7        for(int i=0;i<n;i++){
8            for(int j=0;j<m;j++){
9                if(grid[i][j]==1){
10                    int r = dfs(grid,i,j,0);
11                    ans=Math.max(r,ans);
12                }
13            }
14        }
15        return ans;
16    }
17
18    public static int dfs(int[][]grid , int row , int col , int curr){
19        int n=grid.length;
20        int m = grid[0].length;
21
22        if(row<0 || col<0 || row>=n || col>= m || grid[row][col]==0 ){
23            return  0;
24        }
25
26        grid[row][col]=0;
27        int up = dfs(grid,row-1,col,curr+1);
28        int down = dfs(grid , row+1,col,curr+1);
29        int left = dfs(grid,row,col-1,curr+1);
30        int right = dfs(grid,row,col+1,curr+1);
31        return 1+left+right+up+down;
32    }
33}