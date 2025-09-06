// Last updated: 9/6/2025, 7:46:48 AM
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return LCSBU(nums1,nums2);
    }
    public static int LCSBU(int [] s1,int [] s2) {
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[s1.length][s2.length];
    }
}