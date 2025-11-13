// Last updated: 11/13/2025, 7:55:24 PM
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Topological_sort tp = new Topological_sort(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            tp.AddEdge(prereq, course); // prereq -> course
        }
        return !tp.isCycle(); 
    }
}

class Topological_sort {
    private HashMap<Integer, List<Integer>> map;

    public Topological_sort(int v) {
        map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, new ArrayList<>());
        }
    }

    public void AddEdge(int v1, int v2) {
        map.get(v1).add(v2);
    }

    public int[] indegree() {
        int[] in = new int[map.size()];
        for (int v1 : map.keySet()) {
            for (int v2 : map.get(v1)) {
                in[v2]++;
            }
        }
        return in;
    }

    public boolean isCycle() {
        int[] in = indegree();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            count++;
            for (int nbr : map.get(v)) {
                in[nbr]--;
                if (in[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        return count != map.size();
    }
}
