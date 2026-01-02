// Last updated: 1/2/2026, 10:25:47 AM
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        Topological_sort tp = new Topological_sort(numCourses);
4        for (int i = 0; i < prerequisites.length; i++) {
5            int course = prerequisites[i][0];
6            int prereq = prerequisites[i][1];
7            tp.AddEdge(prereq, course); // prereq -> course
8        }
9        return !tp.isCycle(); 
10    }
11}
12
13class Topological_sort {
14    private HashMap<Integer, List<Integer>> map;
15
16    public Topological_sort(int v) {
17        map = new HashMap<>();
18        for (int i = 0; i < v; i++) {
19            map.put(i, new ArrayList<>());
20        }
21    }
22
23    public void AddEdge(int v1, int v2) {
24        map.get(v1).add(v2);
25    }
26
27    public int[] indegree() {
28        int[] in = new int[map.size()];
29        for (int v1 : map.keySet()) {
30            for (int v2 : map.get(v1)) {
31                in[v2]++;
32            }
33        }
34        return in;
35    }
36
37    public boolean isCycle() {
38        int[] in = indegree();
39        Queue<Integer> q = new LinkedList<>();
40        for (int i = 0; i < in.length; i++) {
41            if (in[i] == 0) {
42                q.add(i);
43            }
44        }
45
46        int count = 0;
47        while (!q.isEmpty()) {
48            int v = q.poll();
49            count++;
50            for (int nbr : map.get(v)) {
51                in[nbr]--;
52                if (in[nbr] == 0) {
53                    q.add(nbr);
54                }
55            }
56        }
57
58        return count != map.size();
59    }
60}
61