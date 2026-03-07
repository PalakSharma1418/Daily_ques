// Last updated: 3/7/2026, 5:41:26 PM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();                     
4        String t = s + s;                        
5        int count0 = 0, count1 = 0;              
6        for (int j = 0; j < n; j++) {
7            char expected = t.charAt(j);  
8            if (expected != (j % 2 == 0 ? '0' : '1')) count0++;
9            if (expected != (j % 2 == 0 ? '1' : '0')) count1++;
10        }
11
12        int min_flips = Math.min(count0, count1);
13        for (int i = 1; i < n; i++) {
14            char old_char = t.charAt(i - 1);
15            char new_char = t.charAt(i + n - 1);
16            int contrib0 = (old_char != '0') ? 1 : 0;
17            int contrib1 = (old_char != '1') ? 1 : 0;
18            boolean last_pos_char = ((n - 1) % 2 == 0);
19            int new_contrib0 = (new_char != (last_pos_char ? '0' : '1')) ? 1 : 0;
20            int new_contrib1 = (new_char != (last_pos_char ? '1' : '0')) ? 1 : 0;
21            count0 = (n - 1) - (count0 - contrib0) + new_contrib0;
22            count1 = (n - 1) - (count1 - contrib1) + new_contrib1;
23            min_flips = Math.min(min_flips, Math.min(count0, count1));
24        }
25
26        return min_flips;
27    }
28}