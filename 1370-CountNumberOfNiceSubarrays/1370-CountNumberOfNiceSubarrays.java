// Last updated: 1/9/2026, 10:57:25 AM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int l = 0, count = 0, odds = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 != 0) {
                odds++;
            }
            while (odds > k) {
                if (nums[l] % 2 != 0) {
                    odds--;
                }
                l++;
            }
            count += (r - l + 1); // all subarrays ending at r
        }
        return count;
    }
}
// Subarrays with 0 to k odd numbers
// − Subarrays with 0 to (k - 1) odd numbers
// = Subarrays with exactly k odd numbers

