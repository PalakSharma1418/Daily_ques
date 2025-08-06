// Last updated: 8/6/2025, 4:41:20 PM
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n= grid.length;
        // col
        for(int row=0;row<n ;row++){
            sort(grid,row,0,n,false);
        }
        // row
        for(int col=1;col<n;col++){
            sort(grid,0,col,n,true);
        }
        
        return grid;
    }
    public void sort(int [][] grid, int row, int col,int m, boolean fl){
        List<Integer> v = new ArrayList<>();
        int r=row,c=col;
        while(r<m && c<m){
            v.add(grid[r][c]);
            r++;c++;
        }
        if(fl){
            Collections.sort(v);
        }
        else{
            Collections.sort(v,Collections.reverseOrder());
        }
        r=row;c=col;
        int ind= 0;
        while(r<m && c<m){
            grid[r++][c++]= v.get(ind++);
        }
    }
}