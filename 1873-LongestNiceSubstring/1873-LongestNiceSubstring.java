// Last updated: 1/9/2026, 10:56:15 AM
class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isNice(sub)) {
                    if (sub.length() > ans.length()) {
                        ans = sub;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isNice(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A']++;
            } else {
                lower[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if ((upper[i] > 0 && lower[i] == 0) ||
                (lower[i] > 0 && upper[i] == 0)) {
                return false;
            }
        }
        return true;
    }
}
