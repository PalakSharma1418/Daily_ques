// Last updated: 12/21/2025, 12:33:39 PM
1class Solution {
2    public String makeLargestSpecial(String s) {
3        List<String> parts = new ArrayList<>();
4        int balance = 0;
5        int start = 0;
6
7        for (int i = 0; i < s.length(); i++) {
8            if (s.charAt(i) == '1') balance++;
9            else balance--;
10
11            if (balance == 0) {
12                String inner = s.substring(start + 1, i);
13                parts.add("1" + makeLargestSpecial(inner) + "0");
14                start = i + 1;
15            }
16        }
17
18        Collections.sort(parts, Collections.reverseOrder());
19        StringBuilder ans = new StringBuilder();
20        for (String p : parts) {
21            ans.append(p);
22        }
23
24        return ans.toString();
25    }
26}
27