// Last updated: 8/6/2025, 4:48:30 PM
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int [] res= new int[k];
        for(int i=0;i<k;i++){
            int frq=0;
            int ele=0;
            int max=Integer.MIN_VALUE;
            for(Integer key : map.keySet()){
                frq= map.get(key);
                if(frq>max){
                    max=frq;
                    ele=key;
                }
            }
            res[i]=ele;
            map.remove(ele);
        }
        return res;
    }
}