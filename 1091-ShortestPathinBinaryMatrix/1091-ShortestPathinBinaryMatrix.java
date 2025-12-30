// Last updated: 12/30/2025, 1:22:20 PM
1class Solution {
2    public int shortestPathBinaryMatrix(int[][] grid) {
3     int n = grid.length;
4     int m = grid[0].length;
5     int[][] dis1 = new int [n][m];
6     for(int i=0;i<n;i++){
7        for(int j=0;j<m;j++){
8            dis1[i][j]=(int)1e9;
9        }
10     }
11     if(grid[0][0]==1 || grid[n-1][m-1]==1){
12        return -1;
13     }   
14      if (n == 1 && m == 1)
15            return 1;
16    dis1[0][0]=1;
17     Queue<int[]> q = new LinkedList<>();
18     q.add(new int[]{0,0,1});
19     int row []= {-1,-1,-1,0,0,1,1,1};
20     int col[] = {-1,0,1,-1,1,-1,0,1};
21     while(!q.isEmpty()){
22        int[] rem= q.poll();
23        int r = rem[0];
24        int c= rem[1];
25        int dis = rem[2];
26        for(int i=0;i<8;i++){
27            int newRow= r+row[i];
28            int newCol= c+col[i];
29            if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]==0 && dis+1< dis1[newRow][newCol]){
30                dis1[newRow][newCol]=dis+1;
31                if(newRow==n-1 && newCol==m-1){
32                    return dis1[newRow][newCol];
33                }
34                q.add(new int[]{newRow,newCol,dis+1});
35            }
36        }
37     }
38     return -1;
39    }
40}