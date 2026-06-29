// Last updated: 6/29/2026, 9:18:12 AM
1class Solution {
2    public boolean validPalindrome(String s) {
3        int l = 0, r = s.length() - 1;
4
5        while (l < r) {
6            if (s.charAt(l) == s.charAt(r)) {
7                l++;
8                r--;
9            } else {
10                return isPalindrome(s, l + 1, r) ||
11                       isPalindrome(s, l, r - 1);
12            }
13        }
14
15        return true;
16    }
17
18    private boolean isPalindrome(String s, int l, int r) {
19        while (l < r) {
20            if (s.charAt(l) != s.charAt(r))
21                return false;
22            l++;
23            r--;
24        }
25        return true;
26    }
27}