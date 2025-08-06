// Last updated: 8/6/2025, 4:46:11 PM
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums,int k) {
        int r=0,l=0;
        int count =0;
        HashMap<Integer,Integer> freq= new HashMap<>();
        // window 
        while( r<nums.length){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            
            if (freq.get(nums[r]) == 1) {
                k--;  // new distinct element
            }

            while (k < 0) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                    k++;  // one distinct removed
                }
                l++;
            }

            count += (r - l + 1);  
            r++;
        }
        return count;
    }
}