// Last updated: 1/25/2026, 8:38:14 AM
1class Solution {
2    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
3        Map<Integer , List<Integer>> map = new HashMap<>();
4        for(int i =0 ; i< n ; i++){
5            map.put(i,new ArrayList<Integer>());
6        }
7
8        for(int i=0 ; i< edges.length; i++){
9            int src = edges[i][0];
10            int des= edges[i][1];
11            map.get(src).add(des);
12            map.get(des).add(src);
13        }
14
15        int[] dx= dist(map,x,n);
16        int[] dy = dist(map,y,n);
17        int[] dz= dist(map,z,n);
18
19        int co=0;
20        for(int i=0 ; i<n ; i++){
21            int a = dx[i];
22            int b = dy[i];
23            int c = dz[i];
24            // int[] arr = {a,b,c};
25            // Arrays.sort(arr);
26            int max=a,min=a,smx=a;
27            max=Math.max(a,Math.max(b,c));
28            min=Math.min(a,Math.min(b,c));
29            smx=(a+b+c)-(max+min);
30
31            if(min*min+smx*smx == max*max ){
32                co++;
33            }
34        }
35        return co;
36    }
37
38    public int[] dist(Map<Integer,List<Integer> >map , int src , int n){
39        int[]dis= new int[n];
40        Arrays.fill(dis,-1);
41        Queue<Integer> q = new LinkedList<>();
42        q.add(src);
43        dis[src]=0;
44
45        while(!q.isEmpty()){
46            int rm = q.poll();
47
48            for(int key : map.get(rm)){
49                if(dis[key]==-1){
50                    dis[key]=dis[rm]+1;
51                    q.add(key);
52                }
53            }
54        }
55    return dis;
56    }
57}