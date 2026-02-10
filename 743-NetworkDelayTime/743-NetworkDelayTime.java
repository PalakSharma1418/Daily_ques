// Last updated: 2/10/2026, 3:25:14 PM
1class Solution {
2    class Pair{
3        int node;
4        int cost;
5        public Pair(int node , int cost){
6            this.node = node;
7            this.cost = cost;
8        }
9    }
10    public int networkDelayTime(int[][] times, int n, int k) {
11         Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
12        
13        for(int[] time : times) {
14            int start = time[0];
15            int end = time[1];
16            int weight = time[2];
17            
18            map.putIfAbsent(start, new HashMap<>());
19            map.get(start).put(end, weight);
20        }
21        int p=0; 
22        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
23        HashSet<Integer> set = new HashSet<>();
24        pq.add(new Pair(k,0));
25        int max = -1;
26        while(!pq.isEmpty()){
27            Pair rm = pq.poll();
28            int cost = rm.cost;
29
30            if(set.contains(rm.node)){
31                continue;
32            }
33
34            set.add(rm.node);
35            p++;
36            max =Math.max(max,cost);
37            if(map.containsKey(rm.node)){
38            for(int nbrs : map.get(rm.node).keySet()){
39                    if(!set.contains(nbrs)){
40                        pq.add(new Pair(nbrs,map.get(rm.node).get(nbrs)+cost));
41                    }
42            }
43            }
44        }
45        if(p!=n){
46            return -1;
47        }
48        return max;
49    }
50}