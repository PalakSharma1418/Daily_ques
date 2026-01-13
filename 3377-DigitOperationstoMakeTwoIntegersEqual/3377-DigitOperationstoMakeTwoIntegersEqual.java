// Last updated: 1/13/2026, 8:15:23 PM
1class Solution {
2    static final int MAX_NUM = 10000;
3    boolean[] prime = new boolean[MAX_NUM];
4    class DijkstraPair {
5        int vtx;
6        int cost;
7
8        DijkstraPair(int vtx, int cost) {
9            this.vtx = vtx;
10            this.cost = cost;
11        }
12
13        public String toString() {
14            return this.vtx + " @ " + this.cost;
15        }
16    }
17    void precomputePrimes() {
18        Arrays.fill(prime, true);
19        prime[0] = false;
20        prime[1] = false;
21
22        for (int i = 2; i * i < MAX_NUM; i++) {
23            if (prime[i]) {
24                for (int j = i * i; j < MAX_NUM; j += i) {
25                    prime[j] = false;
26                }
27            }
28        }
29    }
30
31    List<Integer> getNeighbors(int curr) {
32        List<Integer> neighbors = new ArrayList<>();
33        char[] digits = String.valueOf(curr).toCharArray();
34
35        for (int i = 0; i < digits.length; i++) {
36            char original = digits[i];
37
38            // Increment digit
39            if (original < '9') {
40                digits[i] = (char) (original + 1);
41                int val = Integer.parseInt(new String(digits));
42                if (!prime[val]) neighbors.add(val);
43            }
44
45            // Decrement digit
46            if (original > '0') {
47                digits[i] = (char) (original - 1);
48                int val = Integer.parseInt(new String(digits));
49                if (!prime[val]) neighbors.add(val);
50            }
51
52            digits[i] = original; // backtrack
53        }
54        return neighbors;
55    }
56
57    public int minOperations(int n, int m) {
58
59        precomputePrimes();
60
61        if (prime[n] || prime[m]) return -1;
62        if (n == m) return n;
63
64        PriorityQueue<DijkstraPair> pq =
65                new PriorityQueue<>((a, b) -> a.cost - b.cost);
66
67        HashSet<Integer> visited = new HashSet<>();
68
69        pq.add(new DijkstraPair(n, n));
70
71        while (!pq.isEmpty()) {
72
73            // 1. remove
74            DijkstraPair rp = pq.poll();
75
76            // 2. ignore
77            if (visited.contains(rp.vtx)) {
78                continue;
79            }
80
81            // 3. mark visited
82            visited.add(rp.vtx);
83
84            // 4. self work
85            if (rp.vtx == m) {
86                return rp.cost;
87            }
88
89            // 5. add neighbors
90            for (int nbr : getNeighbors(rp.vtx)) {
91                if (!visited.contains(nbr)) {
92                    pq.add(new DijkstraPair(nbr, rp.cost + nbr));
93                }
94            }
95        }
96
97        return -1;
98    }
99}
100
101