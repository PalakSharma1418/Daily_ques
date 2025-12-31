// Last updated: 12/31/2025, 7:13:31 PM
1class Solution {
2    
3    private HashMap<Integer,HashMap<Integer,Integer>> map;
4    public void AddEdge(int v1, int v2, int cost) {
5		map.get(v1).put(v2, cost);
6		map.get(v2).put(v1, cost);
7	}
8    public boolean hashpath(int src, int dis, HashSet<Integer> visited) {
9		if (src == dis) {
10			return true;
11		}
12		visited.add(src);
13		for (int nbrs : map.get(src).keySet()) {
14			if (!visited.contains(nbrs)) {
15				boolean ans = hashpath(nbrs, dis, visited);
16				if (ans) {
17					return ans;
18				}
19			}
20		}
21		// visited.remove(src); 
22		return false;
23	}
24    public boolean validPath(int n, int[][] edges, int source, int destination) {
25        map = new HashMap<>();
26        for (int i = 0; i < n; i++) {
27            map.put(i, new HashMap<>());
28        }
29        for (int[] e : edges) {
30            AddEdge(e[0], e[1], 1);
31        }
32        return hashpath(source, destination, new HashSet<>());
33    }
34
35}