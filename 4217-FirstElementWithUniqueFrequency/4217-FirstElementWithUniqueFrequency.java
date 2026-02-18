// Last updated: 2/18/2026, 11:34:36 AM
class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        HashMap<Integer,Integer> fre = new HashMap<>();
        for(int key : map.keySet()){
            int f= map.get(key);
            fre.put(f,fre.getOrDefault(f,0)+1);
        }

        // for(int c : fre.keySet()){
        //     if(fre.get(c)==1){
        //         return
        //     }
        // }
        for(int x: nums){
            int frq = map.get(x);
            if(fre.get(frq)==1){
                return x;
            }
        }
        return -1;
    }
}