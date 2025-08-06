// Last updated: 8/6/2025, 4:47:32 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length,count =0;
        int [] prefix= new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
         HashMap<Integer, Integer> map = new HashMap<>();
         for(int i=0;i<n;i++){
            if(prefix[i]==k)  count++;

            int val=prefix[i]-k;
            if (map.containsKey(val))
                count += map.get(val);

            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
         }
         return count;
    }
}