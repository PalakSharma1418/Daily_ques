// Last updated: 1/17/2026, 2:18:10 PM
1class Solution {
2    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
3        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
4        for(int i=0;i<n;i++){
5            map.put(i,new HashMap<>());
6
7        }
8
9        for (int i = 0; i < edges.length; i++) {
10            int u = edges[i][0];
11            int v = edges[i][1];
12            int w = edges[i][2];
13
14            map.get(u).put(v, Math.min(map.get(u).getOrDefault(v, Integer.MAX_VALUE), w));
15            map.get(v).put(u, Math.min(map.get(v).getOrDefault(u, Integer.MAX_VALUE), w));
16        }
17
18
19        int ans []= new int[n];
20        Arrays.fill(ans, -1);
21        if(disappear[0] == 0) return ans;
22        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);
23        HashSet<Integer> visited= new HashSet<>();
24        pq.add(new DijkstraPair(0, 0));
25        while(!pq.isEmpty()){
26            DijkstraPair rp = pq.poll();
27            if(visited.contains(rp.vtx)){
28                continue;
29            }
30
31            visited.add(rp.vtx);
32
33            ans[rp.vtx]=rp.cost;
34
35            for(int nbrs : map.get(rp.vtx).keySet()){
36                if(!visited.contains(nbrs)){
37                    int cost = map.get(rp.vtx).get(nbrs);
38                    if(rp.cost+cost >= disappear[nbrs]) continue;
39                    pq.add(new DijkstraPair(nbrs,rp.cost+cost));
40                }
41            }
42        }
43        return ans;
44
45
46    }
47
48    class  DijkstraPair{
49        int vtx;
50        int cost;
51        public DijkstraPair(int vtx , int cost){
52            this.vtx=vtx;
53            this.cost=cost;
54        }
55    }
56     
57}