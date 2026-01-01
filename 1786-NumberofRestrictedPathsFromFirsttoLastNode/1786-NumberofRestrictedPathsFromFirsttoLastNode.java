// Last updated: 1/1/2026, 7:38:32 PM
1class Pair {
2    int node, weight;
3    
4    Pair(int node, int weight) {
5        this.node = node;
6        this.weight = weight;
7    }
8}
9
10class Solution {
11    public int countRestrictedPaths(int n, int[][] edges) {
12        List<List<Pair>> adj = new ArrayList<>();
13        for (int i = 0; i <= n; i++) {
14            adj.add(new ArrayList<>());
15        }
16
17        for (int[] edge : edges) {
18            int u = edge[0], v = edge[1], w = edge[2];
19            adj.get(u).add(new Pair(v, w));
20            adj.get(v).add(new Pair(u, w));
21        }
22
23        int[] dist = new int[n + 1];
24        int[] ans = new int[n + 1];
25        Arrays.fill(dist, Integer.MAX_VALUE);
26        dist[n] = 0;
27        ans[n] = 1;
28        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
29        heap.offer(new Pair(n, 0));
30        int mod = (int) 1e9 + 7;
31
32        while (!heap.isEmpty()) {
33            Pair top = heap.poll();
34            int d = top.weight, x = top.node;
35            if (d > dist[x]) continue;
36            if (x == 1) break;
37            for (Pair neighbor : adj.get(x)) {
38                int y = neighbor.node, w = neighbor.weight;
39                if (dist[y] > dist[x] + w) {
40                    dist[y] = dist[x] + w;
41                    heap.offer(new Pair(y, dist[y]));
42                }
43                if (dist[y] > dist[x]) {
44                    ans[y] = (ans[y] + ans[x]) % mod;
45                }
46            }
47        }
48        return ans[1];
49    }
50}