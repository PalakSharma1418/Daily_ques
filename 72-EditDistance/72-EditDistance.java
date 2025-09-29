// Last updated: 9/29/2025, 7:24:46 AM
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return Min_Ops(word1, word2, 0, 0, dp);
    }

    public static int Min_Ops(String s, String t, int i, int j, int[][] dp) {
        if (i == s.length()) return t.length() - j; // insert rest of t
        if (j == t.length()) return s.length() - i; // delete rest of s

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = Min_Ops(s, t, i + 1, j + 1, dp);
        } else {
            int D = Min_Ops(s, t, i + 1, j, dp);     // delete
            int R = Min_Ops(s, t, i + 1, j + 1, dp); // replace
            int I = Min_Ops(s, t, i, j + 1, dp);     // insert
            return dp[i][j] = 1 + Math.min(D, Math.min(R, I));
        }
    }
}