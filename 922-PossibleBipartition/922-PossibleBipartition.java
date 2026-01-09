// Last updated: 1/9/2026, 10:58:44 AM
class Solution {

    class Bipartite {
        int vtx;
        int dis;

        public Bipartite(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ll.add(new ArrayList<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            int src = dislikes[i][0] - 1;
            int des = dislikes[i][1] - 1;
            ll.get(src).add(des);
            ll.get(des).add(src);
        }
        Queue<Bipartite> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();

        // Graph may be disconnected
        for (int i = 0; i < n; i++) {
            if (visited.containsKey(i)) continue;
            q.add(new Bipartite(i, 0));
            while (!q.isEmpty()) {
                Bipartite rem = q.poll();
                if (visited.containsKey(rem.vtx)) {
                    if (visited.get(rem.vtx) != rem.dis) {
                        return false; //odd cycle
                    }
                    continue;
                }

                visited.put(rem.vtx, rem.dis);

                // Add neighbors
                for (int nbr : ll.get(rem.vtx)) {
                    if (!visited.containsKey(nbr)) {
                        q.add(new Bipartite(nbr, rem.dis + 1));
                    }
                }
            }
        }
        return true;
    }
}
