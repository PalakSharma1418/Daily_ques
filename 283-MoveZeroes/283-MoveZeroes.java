// Last updated: 8/6/2025, 4:48:42 PM
class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int number : nums) {
            if (number != 0) {
                nums[i++] = number;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0; 
        }
    }
}