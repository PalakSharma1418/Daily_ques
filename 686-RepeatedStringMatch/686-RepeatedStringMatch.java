// Last updated: 12/21/2025, 12:01:45 PM
1class Solution {
2    public int repeatedStringMatch(String a, String b) {
3        StringBuilder sb = new StringBuilder();
4        int count = 0;
5
6        while (sb.length() < b.length() + a.length()) {
7            sb.append(a);
8            count++;
9
10            if (sb.indexOf(b) != -1) {
11                return count;
12            }
13        }
14        return -1;
15    }
16}
17