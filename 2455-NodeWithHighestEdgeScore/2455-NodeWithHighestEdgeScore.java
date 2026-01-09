// Last updated: 1/9/2026, 10:54:58 AM
class Solution {
    public int edgeScore(int[] edges) {
       HashMap<Integer,Long> map = new HashMap<>();
       for(int i=0 ; i< edges.length ; i++){
            int num = edges[i];
            map.put(num,map.getOrDefault(num,0L)+i);
       } 
       long ans = Long.MIN_VALUE;
        int r = Integer.MAX_VALUE;
       for(int key : map.keySet()){
             long s = map.get(key);
            if (s > ans || (s == ans && key < r)) {
                ans = s;
                r = key;
            }
       }
       return r;
    }
}