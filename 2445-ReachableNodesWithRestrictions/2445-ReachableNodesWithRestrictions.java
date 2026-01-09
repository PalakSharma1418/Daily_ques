// Last updated: 1/9/2026, 10:55:00 AM
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restrict) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(i,new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        HashSet<Integer> restricted = new HashSet<>();
            for(int x : restrict){
                restricted.add(x);
            }

        HashSet<Integer> visited = new HashSet<>();

        if(restricted.contains(0)) return 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        int c=0;
        while(!q.isEmpty()){
            int r = q.poll();
            c++;
            for(int no : graph.get(r)){
                if(!restricted.contains(no)){
                    if(!visited.contains(no)){
                        visited.add(no);
                        q.add(no);
                    }
                }
            }
        }
        return c;
    }
}