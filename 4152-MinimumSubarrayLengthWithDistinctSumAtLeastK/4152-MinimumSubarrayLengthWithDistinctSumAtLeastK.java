// Last updated: 2/11/2026, 7:19:57 AM
class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left =0 ; 
        int right =0 ;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int sum=0;
        while(right < n){
            if (map.getOrDefault(nums[right], 0) == 0) {
                sum += nums[right];
            }
            map.put(nums[right] , map.getOrDefault(nums[right] , 0)+1);
            while(left<n && sum>=k){
                ans = Math.min(right-left+1 , ans);
                // yha se left se value hata te jana hia 
                map.put(nums[left] , map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    sum-=nums[left];
                }
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}