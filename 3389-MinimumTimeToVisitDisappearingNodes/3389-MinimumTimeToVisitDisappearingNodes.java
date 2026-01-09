// Last updated: 1/9/2026, 10:52:55 AM
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());

        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            map.get(u).put(v, Math.min(map.get(u).getOrDefault(v, Integer.MAX_VALUE), w));
            map.get(v).put(u, Math.min(map.get(v).getOrDefault(u, Integer.MAX_VALUE), w));
        }


        int ans []= new int[n];
        Arrays.fill(ans, -1);
        if(disappear[0] == 0) return ans;
        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);
        HashSet<Integer> visited= new HashSet<>();
        pq.add(new DijkstraPair(0, 0));
        while(!pq.isEmpty()){
            DijkstraPair rp = pq.poll();
            if(visited.contains(rp.vtx)){
                continue;
            }

            visited.add(rp.vtx);

            ans[rp.vtx]=rp.cost;

            for(int nbrs : map.get(rp.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(rp.vtx).get(nbrs);
                    if(rp.cost+cost >= disappear[nbrs]) continue;
                    pq.add(new DijkstraPair(nbrs,rp.cost+cost));
                }
            }
        }
        return ans;


    }

    class  DijkstraPair{
        int vtx;
        int cost;
        public DijkstraPair(int vtx , int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
     
}