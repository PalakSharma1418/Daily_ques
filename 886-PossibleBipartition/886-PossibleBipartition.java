// Last updated: 1/3/2026, 11:08:13 AM
1class Solution {
2
3    class Bipartite {
4        int vtx;
5        int dis;
6
7        public Bipartite(int vtx, int dis) {
8            this.vtx = vtx;
9            this.dis = dis;
10        }
11    }
12
13    public boolean possibleBipartition(int n, int[][] dislikes) {
14        ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
15        for (int i = 0; i < n; i++) {
16            ll.add(new ArrayList<>());
17        }
18        for (int i = 0; i < dislikes.length; i++) {
19            int src = dislikes[i][0] - 1;
20            int des = dislikes[i][1] - 1;
21            ll.get(src).add(des);
22            ll.get(des).add(src);
23        }
24        Queue<Bipartite> q = new LinkedList<>();
25        HashMap<Integer, Integer> visited = new HashMap<>();
26
27        // Graph may be disconnected
28        for (int i = 0; i < n; i++) {
29            if (visited.containsKey(i)) continue;
30            q.add(new Bipartite(i, 0));
31            while (!q.isEmpty()) {
32                Bipartite rem = q.poll();
33                if (visited.containsKey(rem.vtx)) {
34                    if (visited.get(rem.vtx) != rem.dis) {
35                        return false; //odd cycle
36                    }
37                    continue;
38                }
39
40                visited.put(rem.vtx, rem.dis);
41
42                // Add neighbors
43                for (int nbr : ll.get(rem.vtx)) {
44                    if (!visited.containsKey(nbr)) {
45                        q.add(new Bipartite(nbr, rem.dis + 1));
46                    }
47                }
48            }
49        }
50        return true;
51    }
52}
53