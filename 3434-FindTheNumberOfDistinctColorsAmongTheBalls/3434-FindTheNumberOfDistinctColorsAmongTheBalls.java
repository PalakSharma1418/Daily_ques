// Last updated: 8/6/2025, 4:41:51 PM
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap <Integer , Integer> map1= new HashMap<>();
        HashMap <Integer , Integer> map2= new HashMap<>();
        int ans[]= new int[queries.length];
        int k=0;
        for(int i=0;i< queries.length;i++){
            int idx= queries[i][0];
            int color= queries[i][1];
            int prevColor = map1.getOrDefault(idx, -1);
            if(prevColor !=-1){
                map2.put(prevColor,map2.get(prevColor)-1);
                if (map2.get(prevColor) == 0) {
                    map2.remove(prevColor);
                }
            }
            map1.put(idx, color);
            map2.put(color, map2.getOrDefault(color, 0) + 1);
            ans[k++] = map2.size();
        }
        return ans;
    }
}