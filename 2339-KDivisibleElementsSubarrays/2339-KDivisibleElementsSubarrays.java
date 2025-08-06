// Last updated: 8/6/2025, 4:43:28 PM
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int l = 0, count = 0, odds = 0;
        Set<String> candidate = new HashSet<>();
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % p== 0) {
                odds++;
            }
            while (odds > k) {
                if (nums[l] % p== 0) {
                    odds--;
                }
                l++;
            }
            // all subarrays ending at r
           for (int m = l; m <= r; m++) {
                StringBuilder sb = new StringBuilder();
                for (int i = m; i <= r; i++) {
                    sb.append(nums[i]).append(' ');
                }
                candidate.add(sb.toString());
            }
        }
        return candidate.size();
    }
}