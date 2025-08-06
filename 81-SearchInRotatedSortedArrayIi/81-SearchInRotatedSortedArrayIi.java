// Last updated: 8/6/2025, 4:50:19 PM
class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
             if (nums[left] == nums[mid] && nums[right]==nums[mid]) {//[1,0,1,1,1]
                left++;
                right--;
                continue;
            }
             if(nums[left]<=nums[mid]){
                if(target<nums[mid] && target>=nums[left]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(target>nums[mid] && target <=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
}