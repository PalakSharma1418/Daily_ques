// Last updated: 1/19/2026, 3:29:36 PM
1class Solution {
2    public int minimumEffortPath(int[][] heights) {
3        int n = heights.length;
4        int m = heights[0].length;
5        int[][] dis = new int [n][m];
6        for(int i=0;i<n;i++){
7            for(int j=0;j<m;j++){
8                dis[i][j]=(int)1e9;
9            }
10        }
11        dis[0][0] = 0;
12        int row[]={1,-1,0,0};
13        int col[]={0,0,1,-1};
14        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
15        q.add(new int[]{0,0,0});
16        while(!q.isEmpty()){
17            int r= q.peek()[0];
18            int c = q.peek()[1];
19            int eff = q.peek()[2];
20            q.poll();
21            if(r==heights.length-1 && c==heights[0].length-1){
22                return eff;
23            }
24            if(eff>dis[r][c]) continue;
25            for(int i =0 ; i<4 ; i++){
26                int newr= r+row[i];
27                int newc = c+col[i];
28                if(newr>-1 & newc>-1  & newr<heights.length & newc<heights[0].length)
29                {
30                    int effort=Math.max(eff, Math.abs(heights[r][c]-heights[newr][newc]));
31                if(effort<dis[newr][newc]){
32                    dis[newr][newc]=effort;
33                    q.add(new int[]{newr,newc,effort});
34                }
35                }
36            }
37        }
38        return -1;
39      
40    }
41}