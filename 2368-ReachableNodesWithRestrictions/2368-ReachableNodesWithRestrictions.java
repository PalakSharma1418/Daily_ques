// Last updated: 1/6/2026, 11:23:22 AM
1class Solution {
2    public int reachableNodes(int n, int[][] edges, int[] restrict) {
3        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
4        for(int i=0;i<n;i++){
5            graph.add(i,new ArrayList<>());
6        }
7        for(int[] e : edges){
8            int u = e[0];
9            int v = e[1];
10            graph.get(u).add(v);
11            graph.get(v).add(u);
12        }
13
14
15        HashSet<Integer> restricted = new HashSet<>();
16            for(int x : restrict){
17                restricted.add(x);
18            }
19
20        HashSet<Integer> visited = new HashSet<>();
21
22        if(restricted.contains(0)) return 0;
23
24        Queue<Integer> q = new LinkedList<>();
25        q.add(0);
26        visited.add(0);
27        int c=0;
28        while(!q.isEmpty()){
29            int r = q.poll();
30            c++;
31            for(int no : graph.get(r)){
32                if(!restricted.contains(no)){
33                    if(!visited.contains(no)){
34                        visited.add(no);
35                        q.add(no);
36                    }
37                }
38            }
39        }
40        return c;
41    }
42}