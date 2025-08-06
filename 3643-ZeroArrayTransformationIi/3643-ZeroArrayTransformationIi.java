// Last updated: 8/6/2025, 4:41:35 PM
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (allZero(nums)) {
            return 0;
        }
        int left = 1, right = queries.length;
        int ans = -1;
        // If applying all queries can't make nums zero, return -1
        if (!canMakeZeroArray(right, nums ,queries)) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZeroArray(mid, nums, queries)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    boolean allZero(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];  // Difference array for efficient range updates

        // Apply first `k` queries using a difference array
        for (int i = 0; i < k; i++) {
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            diff[left] += val;       // Add `val` at the start of the range
            diff[right + 1] -= val;  // Subtract `val` at the end of the range
        }

        // Apply difference array to get the modified nums
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i];  // Compute the actual array value after updates
            if (currVal < nums[i]) return false;  // If any value is still greater, return false
        }

        return true;  // If all values are zero or less, return true
    }
}
