// Last updated: 12/31/2025, 7:14:44 PM
1class Solution {
2    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
3        List<List<double[]>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
5
6        for (int i = 0; i < edges.length; i++) {
7            int u = edges[i][0];
8            int v = edges[i][1];
9            adj.get(u).add(new double[]{v, succProb[i]});
10            adj.get(v).add(new double[]{u, succProb[i]});
11        }
12
13        double[] dis = new double[n];
14        Arrays.fill(dis, 0.0);
15        dis[start_node] = 1.0;
16
17        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
18        pq.add(new double[]{start_node, 1.0});
19
20        while (!pq.isEmpty()) {
21            double[] cur = pq.poll();
22            int node = (int) cur[0];
23            double d = cur[1];
24            if(dis[node] > d) continue;
25            for (double[] nbr : adj.get(node)) {
26                int next = (int) nbr[0];
27                double wt = nbr[1];
28                if (d * wt > dis[next]) {
29                    dis[next] = d * wt;
30                    pq.add(new double[]{next, dis[next]});
31                }
32            }
33        }
34        return dis[end_node] == Double.MIN_VALUE ? 0 : dis[end_node];
35    }
36}