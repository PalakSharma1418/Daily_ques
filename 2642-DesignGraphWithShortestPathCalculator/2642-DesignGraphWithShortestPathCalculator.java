// Last updated: 2/10/2026, 4:25:42 PM
1class Graph {
2
3    // adjacency list: node -> (neighbor, weight)
4    List<List<int[]>> graph;
5
6    public Graph(int n, int[][] edges) {
7        graph = new ArrayList<>();
8
9        for(int i = 0; i < n; i++){
10            graph.add(new ArrayList<>());
11        }
12
13        for(int[] e : edges){
14            graph.get(e[0]).add(new int[]{e[1], e[2]});
15        }
16    }
17    
18    public void addEdge(int[] edge) {
19        graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
20    }
21    
22    public int shortestPath(int node1, int node2) {
23
24        int n = graph.size();
25        int[] dist = new int[n];
26        Arrays.fill(dist, Integer.MAX_VALUE);
27
28        PriorityQueue<int[]> pq =
29            new PriorityQueue<>((a,b) -> a[0] - b[0]);
30
31        dist[node1] = 0;
32        pq.add(new int[]{0, node1}); // {distance, node}
33
34        while(!pq.isEmpty()){
35            int[] rm = pq.poll();
36            int cost = rm[0];
37            int node = rm[1];
38
39            if(node == node2) return cost;
40
41            if(cost > dist[node]) continue;
42
43            for(int[] edge : graph.get(node)){
44                int nbr = edge[0];
45                int wt  = edge[1];
46
47                if(cost + wt < dist[nbr]){
48                    dist[nbr] = cost + wt;
49                    pq.add(new int[]{dist[nbr], nbr});
50                }
51            }
52        }
53
54        return -1;
55    }
56}
57
58/**
59 * Your Graph object will be instantiated and called as such:
60 * Graph obj = new Graph(n, edges);
61 * obj.addEdge(edge);
62 * int param_2 = obj.shortestPath(node1,node2);
63 */