// Last updated: 1/9/2026, 10:56:13 AM
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        return updateMatrix(isWater);
    }
    static class Pair{
        int row;
        int col;
        int dis;
        Pair(int row , int col , int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m = mat[0].length;
        int[][]dis= new int[n][m];
        int[][]visited= new int[n][m];
        

        Queue<Pair> q  = new LinkedList<>();
        for(int i=0 ; i< n ;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
            }
        }
        int a[]={1,0,-1,0};
        int b[]={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dit=q.peek().dis;
            q.poll();
            dis[row][col]=dit;
            for(int i=0;i<4;i++){
                int nr = row+a[i];
                int nc = col+b[i];
                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && visited[nr][nc]==0){
                    visited[nr][nc]=1;
                    q.add(new Pair(nr,nc,dit+1));

                }
            }

        }
        return dis;
    }

}