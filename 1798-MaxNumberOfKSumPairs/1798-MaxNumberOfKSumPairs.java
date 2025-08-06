// Last updated: 8/6/2025, 4:45:05 PM
class Solution {
    public int maxOperations(int[] nums, int k) {
        int c=0;
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==k){
                c++;
                left++;
                right--;
            }
            else if(nums[left]+nums[right]<k){
                left++;
            }
            else{
                right--;
            }
        }
        return c;
    }
}