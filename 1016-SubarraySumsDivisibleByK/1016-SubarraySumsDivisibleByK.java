// Last updated: 8/6/2025, 4:46:17 PM
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n= nums.length,count =0;
        int [] prefix= new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
         HashMap<Integer, Integer> map = new HashMap<>();
         map.put(0,1);//taki jab koi agge divisible hota bo increment ho pye
         for(int i=0;i<n;i++){
            int rem=prefix[i]%k;
            if(rem<0){
                rem+=k;
            }
            if (map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
         }
         return count;
    
    }
}   