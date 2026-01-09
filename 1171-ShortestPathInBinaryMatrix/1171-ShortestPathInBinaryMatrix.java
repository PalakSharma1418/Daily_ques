// Last updated: 1/9/2026, 10:57:50 AM
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
     int n = grid.length;
     int m = grid[0].length;
     int[][] dis1 = new int [n][m];
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dis1[i][j]=(int)1e9;
        }
     }
     if(grid[0][0]==1 || grid[n-1][m-1]==1){
        return -1;
     }   
      if (n == 1 && m == 1)
            return 1;
    dis1[0][0]=1;
     Queue<int[]> q = new LinkedList<>();
     q.add(new int[]{0,0,1});
     int row []= {-1,-1,-1,0,0,1,1,1};
     int col[] = {-1,0,1,-1,1,-1,0,1};
     while(!q.isEmpty()){
        int[] rem= q.poll();
        int r = rem[0];
        int c= rem[1];
        int dis = rem[2];
        for(int i=0;i<8;i++){
            int newRow= r+row[i];
            int newCol= c+col[i];
            if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]==0 && dis+1< dis1[newRow][newCol]){
                dis1[newRow][newCol]=dis+1;
                if(newRow==n-1 && newCol==m-1){
                    return dis1[newRow][newCol];
                }
                q.add(new int[]{newRow,newCol,dis+1});
            }
        }
     }
     return -1;
    }
}