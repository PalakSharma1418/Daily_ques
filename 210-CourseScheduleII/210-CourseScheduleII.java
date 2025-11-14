// Last updated: 11/14/2025, 6:36:42 PM
class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        Topological_sort tp = new Topological_sort(numCourses);
        
        // Build graph: prereq -> course
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            tp.AddEdge(prereq, course);
        }

        ArrayList<Integer> order = tp.Topological();

        if (order.size() != numCourses) return new int[0];

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }
}
 class Topological_sort {
    // we are using kahn's code for topological sort 
    private HashMap<Integer,List<Integer>> map;
    public Topological_sort(int v){
        map=new HashMap<>();
        for(int i=0;i<v;i++){
            map.put(i,new ArrayList<>());
         }
    }
    
	public void AddEdge(int v1, int v2) {
		map.get(v1).add(v2);
	}
    public int[] indegree(){
        int [] in = new int[map.size()];
        for(int v1:map.keySet()){
            for(int v2: map.get(v1)){
                in[v2]++;
            }
        }
        return in;
    }
    
	public ArrayList<Integer> Topological() {
        ArrayList<Integer> ll = new ArrayList<>();
		int[] in = indegree();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int v = q.poll();
			// System.out.print(v + " ");
            ll.add(v);
			for (int nbr : map.get(v)) {
                in[nbr]--;
                if (in[nbr] == 0) {
                    q.add(nbr);
                }
            }

		}
		return ll;
	}
}
