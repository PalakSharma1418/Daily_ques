// Last updated: 8/6/2025, 4:41:22 PM
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Math.abs(nums[0] - nums[nums.length - 1]);

        for (int index = 1; index < nums.length; index++) {
            max = Math.max(max, Math.abs(nums[index] - nums[index - 1]));
        }

        return max;
    }
}