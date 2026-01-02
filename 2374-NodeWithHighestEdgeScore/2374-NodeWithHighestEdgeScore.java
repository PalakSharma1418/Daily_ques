// Last updated: 1/2/2026, 3:32:07 PM
1class Solution {
2    public int edgeScore(int[] edges) {
3       HashMap<Integer,Long> map = new HashMap<>();
4       for(int i=0 ; i< edges.length ; i++){
5            int num = edges[i];
6            map.put(num,map.getOrDefault(num,0L)+i);
7       } 
8       long ans = Long.MIN_VALUE;
9        int r = Integer.MAX_VALUE;
10       for(int key : map.keySet()){
11             long s = map.get(key);
12            if (s > ans || (s == ans && key < r)) {
13                ans = s;
14                r = key;
15            }
16       }
17       return r;
18    }
19}