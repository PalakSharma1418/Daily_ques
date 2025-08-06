// Last updated: 8/6/2025, 4:41:32 PM
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        while(i<=n-k){
            HashMap<Integer,Integer> seen= new HashMap<>();
            for(int j=i;j<i+k;j++){
                seen.put(nums[j],1);
            }
            for(int num: seen.keySet()){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            i++;
        }
        int s=-1;
        for(int d: map.keySet()){
            if(map.get(d)==1){
                s= Math.max(s,d);
            }
        }
        return s;
    }
}