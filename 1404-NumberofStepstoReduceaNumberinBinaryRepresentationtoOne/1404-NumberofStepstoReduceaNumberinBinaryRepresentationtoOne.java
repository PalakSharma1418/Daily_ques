// Last updated: 2/26/2026, 8:01:03 PM
1class Solution {
2    public int numSteps(String s) {
3        int steps = 0, carry = 0;
4        for (int i = s.length() - 1; i > 0; i--) {
5            if ((s.charAt(i) & 1) + carry == 1) {
6                steps += 2;
7                carry = 1;
8            } else
9                steps += 1;
10        }
11
12        return steps + carry;
13    }
14}