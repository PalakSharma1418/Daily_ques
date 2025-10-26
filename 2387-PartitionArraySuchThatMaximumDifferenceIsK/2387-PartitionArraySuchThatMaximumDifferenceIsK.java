// Last updated: 10/26/2025, 6:47:25 PM
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0];
        int c=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] - min>k){
                c++;
                min=nums[i];
            }
        }
        return c;
    }
}