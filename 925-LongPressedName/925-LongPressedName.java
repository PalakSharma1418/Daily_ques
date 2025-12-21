// Last updated: 12/21/2025, 8:54:56 AM
1class Solution {
2    public boolean isLongPressedName(String name, String typed) { 
3        int i = 0, n = name.length(), m = typed.length();
4
5        for (int j = 0; j < m; ++j) {
6            if (i < n && name.charAt(i) == typed.charAt(j)) {
7                i++;
8            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
9                return false;
10            }
11        }
12
13        return i == n;
14    }
15}