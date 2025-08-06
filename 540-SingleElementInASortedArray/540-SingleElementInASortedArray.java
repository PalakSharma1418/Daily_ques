// Last updated: 8/6/2025, 4:47:36 PM
class Solution {
    public int singleNonDuplicate(int[] nums) {
       int  left=0;
       int right= nums.length-1;
       while(left<right){
         int mid= (left+right)/2;
         int lastindex=mid;
         if( nums[mid]==nums[mid-1]){
            lastindex=mid;
         }
         else if(nums[mid]==nums[mid+1]){
            lastindex=mid+1;
         }
         else{
            return nums[mid];
         }

         if(lastindex%2!=0){
            left= lastindex+1;
         }
         else{
            right= lastindex-2;
         }
       }
       return nums[right];

    }
}