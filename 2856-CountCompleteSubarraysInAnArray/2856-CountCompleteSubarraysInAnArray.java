// Last updated: 10/26/2025, 6:46:25 PM
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            seen.add(nums[i]);
        }
        int k=seen.size();
        int l=0,r=0;
        int count =0;
        HashMap<Integer,Integer> freq= new HashMap<>();
        while( r<nums.length){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            while(freq.size()==k){
                // all subarray start with l
                count+=(nums.length-r);
                // now remove l 
                freq.put(nums[l],freq.getOrDefault(nums[l],0)-1);
                // if element not present remove it to preserve  the frequency
                if(freq.get(nums[l])==0){
                    freq.remove(nums[l]);
                }
                l++;
            }
            r++;
        }
        return count;
    }
}
// If we already have k distinct elements (which are all distinct elements of the array), then adding more elements won’t help us find new complete subarrays starting at the same index — so we just count all of them in one go.    count=(n-j);