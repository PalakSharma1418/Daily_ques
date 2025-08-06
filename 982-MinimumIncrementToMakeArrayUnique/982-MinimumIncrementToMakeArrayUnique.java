// Last updated: 8/6/2025, 4:46:24 PM
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        int step = 0;
        int prev = nums[0]; // Start with the first element
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                // If the current value is not greater than the previous,
                // we need to increment it to (prev + 1)
                step += (prev + 1 - nums[i]);  // Steps needed to make it unique
                prev = prev + 1;               // Update prev to new value
            } else {
                prev = nums[i]; // No conflict, move forward
            }
        }
        return step;
    }
}
