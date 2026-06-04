// Last updated: 6/4/2026, 8:00:43 PM
1class Solution {
2    private int waviness(int x) {
3        String s = Integer.toString(x);
4        int cnt = 0;
5        for (int i = 1; i < s.length() - 1; i++) {
6            char cur = s.charAt(i);
7
8            if ((cur > s.charAt(i - 1) && cur > s.charAt(i + 1)) ||
9                (cur < s.charAt(i - 1) && cur < s.charAt(i + 1))) {
10                cnt++;
11            }
12        }
13        return cnt;
14    }
15    public int totalWaviness(int num1, int num2) {
16        int ans = 0;
17
18        for (int x = num1; x <= num2; x++) {
19            ans += waviness(x);
20        }
21
22        return ans;
23    }
24}