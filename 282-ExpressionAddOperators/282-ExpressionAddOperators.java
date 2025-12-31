// Last updated: 12/31/2025, 11:47:57 AM
1class Solution {
2    public List<String> addOperators(String num, int target) {
3        List<String> ans = new ArrayList<>();
4        fun(ans, num, target, 0, 0, "");
5        return ans;
6    }
7
8    public static void fun(List<String> ans, String num, int target,
9                           long curr, long prev, String z) {
10
11        if (num.length() == 0) {
12            if (curr == target) {
13                ans.add(z);
14            }
15            return;
16        }
17
18        for (int i = 1; i <= num.length(); i++) {
19
20            // leading zero check
21            if (i > 1 && num.charAt(0) == '0') break;
22
23            String a = num.substring(0, i);
24            long b = Long.parseLong(a);
25            String rest = num.substring(i);
26
27            if (z.length() == 0) {
28                fun(ans, rest, target, b, b, a);
29            } else {
30                fun(ans, rest, target,curr + b,b,z + "+" + a);
31                fun(ans, rest, target,curr - b,-b,z + "-" + a);
32   fun(ans, rest, target,curr - prev + prev * b,prev * b,z + "*" + a);
33            }
34        }
35    }
36}
37