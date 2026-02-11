// Last updated: 2/11/2026, 5:33:16 AM
1class Solution {
2    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
3        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
4        for (int i = 0; i < n; i++) {
5            graph.add(new ArrayList<>());
6        }
7        for (int[] e : edges) {
8            int u = e[0];
9            int v = e[1];
10            int w = e[2];
11            graph.get(u).add(new int[]{v, w});
12            graph.get(v).add(new int[]{u, w});
13        }
14        int ans = -1;
15        int minCount = Integer.MAX_VALUE;
16
17        // har city se dijkstra
18        for (int src = 0; src < n; src++) {
19            int count = dijkstra(src, graph, n, distanceThreshold);
20
21            // tie case me bigger index
22            if (count <= minCount) {
23                minCount = count;
24                ans = src;
25            }
26        }
27
28        return ans;
29    }
30
31    private int dijkstra(int src,ArrayList<ArrayList<int[]>> graph,int n,int threshold) {
32        int[] dist = new int[n];
33        Arrays.fill(dist, Integer.MAX_VALUE);
34        dist[src] = 0;
35        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) -> a[1] - b[1]);
36        pq.add(new int[]{src, 0});
37        while (!pq.isEmpty()) {
38            int[] rm = pq.poll();
39            int node = rm[0];
40            int cost = rm[1];
41
42            if (cost > dist[node]) continue;
43
44            for (int[] arr : graph.get(node)) {
45                int nbr = arr[0];
46                int wt  = arr[1];
47                int nc = cost + wt;
48                if (nc < dist[nbr]) {
49                    dist[nbr] = nc;
50                    pq.add(new int[]{nbr, nc});
51                }
52            }
53        }
54
55        // threshold ke andar count
56        int cnt = 0;
57        for (int i = 0; i < n; i++) {
58            if (i != src && dist[i] <= threshold) {
59                cnt++;
60            }
61        }
62
63        return cnt;
64    }
65}
66