// Last updated: 12/11/2025, 7:34:03 AM
class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int rem = num % 3;
            if (rem != 0) {
                res += Math.min(rem, 3 - rem);
            }
        }
        return res;
    }
}
