// Last updated: 10/26/2025, 6:46:24 PM
class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        int firstOne = -1;
        
        // Step 1: Find the first 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                firstOne = i;
                break;
            }
        }

        // Step 2: If no 1 found → return 0 (no good subarray possible)
        if (firstOne == -1) return 0;

        long ans = 1; // Use long to avoid overflow
        int prev = firstOne;

        // Step 3: From the next index, look for more 1s and count zeros between them
        for (int i = firstOne + 1; i < n; i++) {
            if (nums[i] == 1) {
                int gap = i - prev - 1; // number of 0s between two 1s
                ans = (ans * (gap + 1)) % MOD;
                prev = i;
            }
        }

        return (int) ans;
    }
}



 
// 1 | 0 0 1 (all zeros with 2nd 1)
// 1 0 | 0 1
// 1 0 0 | 1 (all zeros with 1st 1)
// → z + 1 = 3 options
// If there are multiple 1s, and z1, z2, ... zeros between them:
// totalWays = (z1 + 1) * (z2 + 1) * ... (mod 10^9 + 7)