// Last updated: 8/6/2025, 4:50:20 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 0;
                nums[current++] = nums[i];
            } else {
                count++;
                if (count <= 1) nums[current++] = nums[i];
            }
        }
        return current;
    }
}