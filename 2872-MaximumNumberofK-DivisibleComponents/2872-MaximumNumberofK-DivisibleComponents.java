// Last updated: 11/28/2025, 7:24:18 PM
1class Solution {
2    private List<Integer>[] graph;
3    private int[] values;
4    private int k;
5    private int count;
6
7    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
8        this.values = values;
9        this.k = k;
10        this.count = 0;
11
12        graph = new ArrayList[n];
13        for (int i = 0; i < n; i++) {
14            graph[i] = new ArrayList<>();
15        }
16
17        for (int[] edge : edges) {
18            int a = edge[0], b = edge[1];
19            graph[a].add(b);
20            graph[b].add(a);
21        }
22
23        dfs(0, -1);
24
25        return count;
26    }
27
28    public long dfs(int node, int parent) {
29        long total = values[node];
30
31        for (int neighbor : graph[node]) {
32            if (neighbor != parent) {
33                total += dfs(neighbor, node);
34            }
35        }
36
37        if (total % k == 0) {
38            count += 1;
39            return 0;
40        }
41
42        return total;
43    }
44}