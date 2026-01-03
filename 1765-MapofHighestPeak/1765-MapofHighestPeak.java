// Last updated: 1/3/2026, 12:54:08 PM
1class Solution {
2    public int[][] highestPeak(int[][] isWater) {
3        return updateMatrix(isWater);
4    }
5    static class Pair{
6        int row;
7        int col;
8        int dis;
9        Pair(int row , int col , int dis){
10            this.row=row;
11            this.col=col;
12            this.dis=dis;
13        }
14    }
15    public int[][] updateMatrix(int[][] mat) {
16        int n= mat.length;
17        int m = mat[0].length;
18        int[][]dis= new int[n][m];
19        int[][]visited= new int[n][m];
20        
21
22        Queue<Pair> q  = new LinkedList<>();
23        for(int i=0 ; i< n ;i++){
24            for(int j=0;j<m;j++){
25                if(mat[i][j]==1){
26                    q.add(new Pair(i,j,0));
27                    visited[i][j]=1;
28                }
29            }
30        }
31        int a[]={1,0,-1,0};
32        int b[]={0,1,0,-1};
33        while(!q.isEmpty()){
34            int row=q.peek().row;
35            int col=q.peek().col;
36            int dit=q.peek().dis;
37            q.poll();
38            dis[row][col]=dit;
39            for(int i=0;i<4;i++){
40                int nr = row+a[i];
41                int nc = col+b[i];
42                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && visited[nr][nc]==0){
43                    visited[nr][nc]=1;
44                    q.add(new Pair(nr,nc,dit+1));
45
46                }
47            }
48
49        }
50        return dis;
51    }
52
53}