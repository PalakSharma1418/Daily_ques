// Last updated: 8/6/2025, 4:51:20 PM
class Solution {
    // public int removeElement(int[] nums, int val) {
    //     int c=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]==val){
    //             int f=nums[i];
    //             int j=i+1;
    //             while(j<nums.length-1){
    //                 nums[i]=nums[i+1];
    //             }
    //             nums[nums.length-1]=f;
    //         }
    //     }
    //     return nums.length-c;
    // }
     public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}