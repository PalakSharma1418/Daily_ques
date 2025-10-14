// Last updated: 10/14/2025, 7:30:30 PM
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