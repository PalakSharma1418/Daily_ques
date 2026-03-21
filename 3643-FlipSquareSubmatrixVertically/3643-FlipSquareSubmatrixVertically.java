// Last updated: 3/21/2026, 7:25:49 PM
1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        int t=x;
4        int b=x+k-1;
5        while(t<b){
6            for(int j=0;j<k;j++){
7                int te=grid[t][y+j];
8                grid[t][y+j]=grid[b][y+j];
9                grid[b][y+j]=te;
10            }
11            t++;
12            b--;
13        }
14        return grid;
15    }
16}