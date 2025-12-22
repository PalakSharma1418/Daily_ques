// Last updated: 12/22/2025, 11:59:46 AM
1class Solution {
2    public String longestNiceSubstring(String s) {
3        String ans = "";
4        int n = s.length();
5
6        for (int i = 0; i < n; i++) {
7            for (int j = i; j < n; j++) {
8                String sub = s.substring(i, j + 1);
9                if (isNice(sub)) {
10                    if (sub.length() > ans.length()) {
11                        ans = sub;
12                    }
13                }
14            }
15        }
16        return ans;
17    }
18
19    public boolean isNice(String s) {
20        int[] upper = new int[26];
21        int[] lower = new int[26];
22
23        for (int i = 0; i < s.length(); i++) {
24            char ch = s.charAt(i);
25            if (ch >= 'A' && ch <= 'Z') {
26                upper[ch - 'A']++;
27            } else {
28                lower[ch - 'a']++;
29            }
30        }
31
32        for (int i = 0; i < 26; i++) {
33            if ((upper[i] > 0 && lower[i] == 0) ||
34                (lower[i] > 0 && upper[i] == 0)) {
35                return false;
36            }
37        }
38        return true;
39    }
40}
41