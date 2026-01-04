// Last updated: 1/4/2026, 3:35:40 PM
1class Solution {
2   List<Integer> cost ;
3    public int countPaths(int n, int[][] roads) {
4        cost = new ArrayList<>();
5        // boolean[] visited = new boolean[n];
6        List<List<int[]>> adjList = new ArrayList<>();
7        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>()) ;
8        for(int[] road : roads){
9            int u = road[0];
10            int v = road[1];
11            int t = road[2];
12            adjList.get(u).add(new int[]{v , t});
13            adjList.get(v).add(new int[]{u , t});
14        }
15        
16        //Dijsktra algo
17        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0] , b[0]));
18        pq.add(new long[]{0 , 0});
19        // int MOD = (int)1e9 + 7 ;
20        int MOD = 1_000_000_007 ;
21        long[] dist = new long[n];
22        int[] ways = new int[n];
23        ways[0] = 1 ;
24        Arrays.fill(dist , Long.MAX_VALUE);
25        while(!pq.isEmpty()){
26            long[] curr = pq.poll();
27            int node = (int)curr[1];
28            long cost = curr[0];
29
30            if(dist[node] < cost) continue ;
31            for(int[] nei : adjList.get(node)){
32                int neiNode = nei[0];
33                int neiCost = nei[1];
34                long newCost = neiCost + cost ;
35                if(newCost < dist[neiNode]){
36                    dist[neiNode] = newCost ; 
37                    ways[neiNode] = ways[node];
38                    pq.add(new long[]{newCost , neiNode});
39                }else if(newCost == dist[neiNode]){
40                    ways[neiNode] = (ways[neiNode] + ways[node])%MOD ;
41                }
42            }
43        }
44        return ways[n-1];
45    }
46}