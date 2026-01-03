// Last updated: 1/3/2026, 7:17:16 PM
1class Solution {
2    Map<Integer, List<Integer>> adj = new HashMap<>();
3    Map<Integer, Integer> bobMap = new HashMap<>();
4    int aliceIncome;
5
6    boolean DFSBob(int curr, int t, boolean[] visited) {
7        visited[curr] = true;
8        bobMap.put(curr, t);
9
10        if (curr == 0) { // reached target
11            return true;
12        }
13
14        for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
15            if (!visited[ngbr]) {
16                if (DFSBob(ngbr, t + 1, visited)) {
17                    return true;
18                }
19            }
20        }
21
22        bobMap.remove(curr);
23        return false;
24    }
25
26    void DFSAlice(int curr, int t, int income, boolean[] visited, int[] amount) {
27        visited[curr] = true;
28
29        if (!bobMap.containsKey(curr) || t < bobMap.get(curr)) {
30            income += amount[curr];
31        } else if (t == bobMap.get(curr)) {
32            income += (amount[curr] / 2);
33        }
34
35        if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) { // leaf node
36            aliceIncome = Math.max(aliceIncome, income);
37        }
38        for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
39            if (!visited[ngbr]) {
40                DFSAlice(ngbr, t + 1, income, visited, amount);
41            }
42        }
43    }
44
45    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
46        int n = amount.length; // n nodes (0 to n-1)
47        aliceIncome = Integer.MIN_VALUE;
48
49        for (int[] edge : edges) {
50            int u = edge[0];
51            int v = edge[1];
52
53            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
54            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
55        }
56
57        // DFS on Bob for finding time to reach each node till 0
58        int time = 0;
59        boolean[] visited = new boolean[n];
60        DFSBob(bob, time, visited);
61
62        int income = 0;
63        Arrays.fill(visited, false);
64        DFSAlice(0, 0, income, visited, amount);
65
66        return aliceIncome;
67    }
68}
69
70//mik
71