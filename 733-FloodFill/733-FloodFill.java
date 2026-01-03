// Last updated: 1/3/2026, 5:56:50 AM
1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        int intial= image[sr][sc];
4        if (intial == color) return image;
5        bfs(image,sr,sc,color,intial);
6        return image;
7    }
8    public static void bfs(int[][]img , int sr ,int sc , int color,int intial){
9        int n = img.length;
10        int m = img[0].length;
11        int[] r ={-1,1,0,0};
12        int[]c ={0,0,-1,1};
13        Queue<int[]> q = new LinkedList<>();
14        q.add( new int[]{sr,sc});
15        img[sr][sc]=color;
16        while(!q.isEmpty()){
17            int [] rm = q.poll();
18            int row = rm[0];
19            int col= rm[1];
20            for(int i=0;i<4;i++){
21                int nr= row+r[i];
22                int nc= col+c[i];
23                if(nr>=0 && nr < n && nc>=0 && nc<m && img[nr][nc]== intial){
24                    q.add(new int[]{nr,nc} );
25                    img[nr][nc]=color;
26                }
27            }            
28        }
29    }
30}