// Last updated: 11/22/2025, 9:49:19 AM
class Solution {
    
    private HashMap<Integer,HashMap<Integer,Integer>> map;
    public void AddEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
    public boolean hashpath(int src, int dis, HashSet<Integer> visited) {
		if (src == dis) {
			return true;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				boolean ans = hashpath(nbrs, dis, visited);
				if (ans) {
					return ans;
				}
			}
		}
		// visited.remove(src); 
		return false;
	}
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] e : edges) {
            AddEdge(e[0], e[1], 1);
        }
        return hashpath(source, destination, new HashSet<>());
    }

}