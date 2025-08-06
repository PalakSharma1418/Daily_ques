// Last updated: 8/6/2025, 4:49:47 PM
class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }
        return -1; 
    }
}