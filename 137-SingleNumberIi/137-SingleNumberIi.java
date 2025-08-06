// Last updated: 8/6/2025, 4:49:45 PM
class Solution {
    public int singleNumber(int[] nums) {
           Map<Integer, Integer> map = new HashMap<>();
        
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> f :map.entrySet()){
            if(f.getValue()==1){
                return f.getKey();
            }
        }
        return -1;
    }
}