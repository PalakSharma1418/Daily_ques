// Last updated: 2/18/2026, 11:35:44 AM
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int steps = nums[i];
                int newIndex = ((i + steps) % n + n) % n;
                result[i] = nums[newIndex];
            }
        }
        return result;
    }
}