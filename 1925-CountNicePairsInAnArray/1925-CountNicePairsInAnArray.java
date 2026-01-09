// Last updated: 1/9/2026, 10:56:04 AM
class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Long> map = new HashMap<>();
        int MOD = 1_000_000_007;

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - rev(nums[i]);
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        long ans = 0;
        for (long c : map.values()) {
            ans = (ans + (c * (c - 1) / 2) % MOD) % MOD;
        }

        return (int) ans;
    }

    public int rev(int n) {
        int ans = 0;
        while (n > 0) {
            ans = ans * 10 + (n % 10);
            n /= 10;
        }
        return ans;
    }
}
