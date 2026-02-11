// Last updated: 2/11/2026, 6:07:10 AM
1class Solution {
2    public int secondMinimum(int n, int[][] edges, int time, int change) {
3        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
4        for (int i = 0; i < n; i++) {
5            graph.add(new ArrayList<>());
6        }
7        for (int[] e : edges) {
8            int u = e[0] - 1;
9            int v = e[1] - 1;
10            graph.get(u).add(v);
11            graph.get(v).add(u);
12        }
13
14        int INF = Integer.MAX_VALUE;
15
16        // dist1 = shortest, dist2 = second shortest
17        int[] dist1 = new int[n];
18        int[] dist2 = new int[n];
19        Arrays.fill(dist1, INF);
20        Arrays.fill(dist2, INF);
21
22        dist1[0] = 0;
23
24        PriorityQueue<int[]> pq =
25            new PriorityQueue<>((a, b) -> a[1] - b[1]);
26
27        pq.add(new int[]{0, 0});
28
29        while (!pq.isEmpty()) {
30            int[] rm = pq.poll();
31            int node = rm[0];
32            int cost = rm[1];
33
34            for (int nbr : graph.get(node)) {
35
36                int curr = cost;
37
38                if ((curr / change) % 2 == 1) {
39                    curr = ((curr / change )+ 1) * change;
40                }
41
42                int nc = curr + time;
43
44                if (nc < dist1[nbr]) {
45                    dist2[nbr] = dist1[nbr];
46                    dist1[nbr] = nc;
47                    pq.add(new int[]{nbr, nc});
48                }
49                else if (nc > dist1[nbr] && nc < dist2[nbr]) {
50                    dist2[nbr] = nc;
51                    pq.add(new int[]{nbr, nc});
52                }
53            }
54        }
55
56        return dist2[n - 1];
57    }
58}
59