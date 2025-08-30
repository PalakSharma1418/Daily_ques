// Last updated: 8/30/2025, 8:13:54 PM
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int t=x;
        int b=x+k-1;
        while(t<b){
            for(int j=0;j<k;j++){
                int te=grid[t][y+j];
                grid[t][y+j]=grid[b][y+j];
                grid[b][y+j]=te;
            }
            t++;
            b--;
        }
        return grid;
    }
}