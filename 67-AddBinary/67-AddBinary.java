// Last updated: 2/15/2026, 6:25:19 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder result = new StringBuilder();
4        int i = a.length() - 1, j = b.length() - 1, carry = 0;
5
6        while (i >= 0 || j >= 0 || carry == 1) {
7            int sum = carry;
8            if (i >= 0) sum += a.charAt(i--) - '0';
9            if (j >= 0) sum += b.charAt(j--) - '0';
10
11            result.append(sum % 2);
12            carry = sum / 2;
13        }
14
15        return result.reverse().toString();
16    }
17}