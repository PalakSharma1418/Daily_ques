// Last updated: 8/6/2025, 4:44:03 PM
class Solution {
   List<Integer> cost ;
    public int countPaths(int n, int[][] roads) {
        cost = new ArrayList<>();
        // boolean[] visited = new boolean[n];
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>()) ;
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int t = road[2];
            adjList.get(u).add(new int[]{v , t});
            adjList.get(v).add(new int[]{u , t});
        }
        
        //Dijsktra algo
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0] , b[0]));
        pq.add(new long[]{0 , 0});
        // int MOD = (int)1e9 + 7 ;
        int MOD = 1_000_000_007 ;
        long[] dist = new long[n];
        int[] ways = new int[n];
        ways[0] = 1 ;
        Arrays.fill(dist , Long.MAX_VALUE);
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int)curr[1];
            long cost = curr[0];

            if(dist[node] < cost) continue ;
            for(int[] nei : adjList.get(node)){
                int neiNode = nei[0];
                int neiCost = nei[1];
                long newCost = neiCost + cost ;
                if(newCost < dist[neiNode]){
                    dist[neiNode] = newCost ; 
                    ways[neiNode] = ways[node];
                    pq.add(new long[]{newCost , neiNode});
                }else if(newCost == dist[neiNode]){
                    ways[neiNode] = (ways[neiNode] + ways[node])%MOD ;
                }
            }
        }
        return ways[n-1];
    }
}