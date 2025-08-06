// Last updated: 8/6/2025, 4:42:24 PM
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int freq=nums.length;
        while(freq!=0){
            List<Integer> ap=new ArrayList<>();
            for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
                if(mapElement.getValue()!=0){
                    ap.add(mapElement.getKey());
                    map.put(mapElement.getKey(),mapElement.getValue()-1);
                    freq--;
                }
            }
        res.add(ap);
        }
        return res;
    }
}