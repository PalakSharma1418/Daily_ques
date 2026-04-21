// Last updated: 4/21/2026, 10:58:42 AM
1class Solution {
2    private int[] parent;
3
4    private int find(int x) {
5        if (parent[x] != x) parent[x] = find(parent[x]);
6        return parent[x];
7    }
8
9    private void unite(int a, int b) {
10        parent[find(a)] = find(b);
11    }
12
13    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
14        int n = source.length;
15        parent = new int[n];
16        for (int i = 0; i < n; i++) parent[i] = i;
17
18        for (int[] swap : allowedSwaps) {
19            unite(swap[0], swap[1]);
20        }
21        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
22        for (int i = 0; i < n; i++) {
23            int root = find(i);
24            groups.computeIfAbsent(root, k -> new HashMap<>())
25                  .merge(source[i], 1, Integer::sum);
26        }
27
28        int hammingDist = 0;
29        for (int i = 0; i < n; i++) {
30            int root = find(i);
31            Map<Integer, Integer> freq = groups.get(root);
32            if (freq.getOrDefault(target[i], 0) > 0) {
33                freq.merge(target[i], -1, Integer::sum); 
34            } else {
35                hammingDist++;  
36            }
37        }
38
39        return hammingDist;
40    }
41}