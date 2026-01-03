// Last updated: 1/3/2026, 12:49:18 PM
1class Solution {
2    static class Pair{
3        int row;
4        int col;
5        int dis;
6        Pair(int row , int col , int dis){
7            this.row=row;
8            this.col=col;
9            this.dis=dis;
10        }
11    }
12    public int[][] updateMatrix(int[][] mat) {
13        int n= mat.length;
14        int m = mat[0].length;
15        int[][]dis= new int[n][m];
16        int[][]visited= new int[n][m];
17        Queue<Pair> q  = new LinkedList<>();
18        for(int i=0 ; i< n ;i++){
19            for(int j=0;j<m;j++){
20                if(mat[i][j]==0){
21                    q.add(new Pair(i,j,0));
22                    visited[i][j]=1;
23                }
24            }
25        }
26        int a[]={1,0,-1,0};
27        int b[]={0,1,0,-1};
28        while(!q.isEmpty()){
29            int row=q.peek().row;
30            int col=q.peek().col;
31            int dit=q.peek().dis;
32            q.poll();
33            dis[row][col]=dit;
34            for(int i=0;i<4;i++){
35                int nr = row+a[i];
36                int nc = col+b[i];
37                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && visited[nr][nc]==0){
38                    visited[nr][nc]=1;
39                    q.add(new Pair(nr,nc,dit+1));
40
41                }
42            }
43
44        }
45        return dis;
46    }
47
48}