// Last updated: 3/14/2026, 7:45:34 PM
1class Solution {
2    private String ans;
3    private int count;
4    public void fun(String s, StringBuilder sb, int ind, int n, int k) {
5        if (ind == n) {
6            count++;
7            if (count == k) {
8                ans = sb.toString();
9            }
10            return;
11        }
12        for (int i = 0; i < s.length(); i++) {
13            if (sb.length() == 0 || s.charAt(i) != sb.charAt(sb.length() - 1)) {
14                sb.append(s.charAt(i));
15                fun(s, sb, ind + 1, n, k);
16                if (!ans.isEmpty()) {
17                    return;
18                }
19                sb.deleteCharAt(sb.length() - 1); 
20            }
21        }
22    }
23    public String getHappyString(int n, int k) {
24        ans = "";
25        count = 0;
26        fun("abc", new StringBuilder(), 0, n, k);
27        return ans;
28    }
29}