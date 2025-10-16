// Last updated: 10/16/2025, 11:50:47 AM
import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return help(s, p, n - 1, m - 1, dp);
    }

    public boolean help(String s, String p, int i, int j, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {//only pattern remainaning 
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != null) return dp[i][j];
        boolean ans;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = help(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            ans = help(s, p, i - 1, j, dp) || help(s, p, i, j - 1, dp);
        } else {
            ans = false;
        }
        dp[i][j] = ans;
        return ans;
    }
}
