// Last updated: 3/3/2026, 6:21:42 PM
1
2class Solution {
3
4    public int makeConnected(int n, int[][] connections) {
5
6        // Step 1: if edges less than n-1, impossible
7        if (connections.length < n - 1) {
8            return -1;
9        }
10
11        DisJoinSet ds = new DisJoinSet();
12
13        // Create set for all nodes
14        for (int i = 0; i < n; i++) {
15            ds.create(i);
16        }
17
18        int extraEdges = 0;
19
20        // Step 2: process connections
21        for (int[] edge : connections) {
22            int u = edge[0];
23            int v = edge[1];
24
25            if (ds.find(u) == ds.find(v)) {
26                extraEdges++;  // cycle → extra edge
27            } else {
28                ds.union(u, v);
29            }
30        }
31
32        // Step 3: count components
33        HashSet<Integer> components = new HashSet<>();
34
35        for (int i = 0; i < n; i++) {
36            components.add(ds.find(i));
37        }
38
39        int compCount = components.size();
40
41        // Step 4: check if enough extra edges
42        if (extraEdges >= compCount - 1) {
43            return compCount - 1;
44        } else {
45            return -1;
46        }
47    }
48
49    // ---------------- DSU ----------------
50
51    class DisJoinSet {
52        class Node {
53            int val;
54            int rank;
55            Node parent;
56        }
57
58        private HashMap<Integer, Node> map = new HashMap<>();
59
60        public void create(int v) {
61            Node nn = new Node();
62            nn.val = v;
63            nn.rank = 0;
64            nn.parent = nn;
65            map.put(v, nn);
66        }
67
68        public int find(int v) {
69            return find(map.get(v)).val;
70        }
71
72        private Node find(Node node) {
73            if (node.parent == node) {
74                return node;
75            }
76            node.parent = find(node.parent);  // path compression
77            return node.parent;
78        }
79
80        public void union(int v1, int v2) {
81            Node root1 = find(map.get(v1));
82            Node root2 = find(map.get(v2));
83
84            if (root1 == root2) return;
85
86            if (root1.rank < root2.rank) {
87                root1.parent = root2;
88            } else if (root1.rank > root2.rank) {
89                root2.parent = root1;
90            } else {
91                root2.parent = root1;
92                root1.rank++;
93            }
94        }
95    }
96}