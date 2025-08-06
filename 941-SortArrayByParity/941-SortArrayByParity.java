// Last updated: 8/6/2025, 4:46:34 PM
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }

        return nums;        
    }
}