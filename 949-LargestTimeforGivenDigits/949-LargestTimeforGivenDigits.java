// Last updated: 12/21/2025, 11:01:16 AM
1class Solution {
2    String max = "";
3
4    public String largestTimeFromDigits(int[] arr) {
5        boolean[] used = new boolean[4];
6        backtrack(arr, used, "");
7        return max.equals("") ? "" : max.substring(0,2) + ":" + max.substring(2);
8    }
9
10    private void backtrack(int[] arr, boolean[] used, String s) {
11        if (s.length() == 4) {
12            int hour= Integer.parseInt(s.substring(0, 2));
13            int min = Integer.parseInt(s.substring(2));
14
15            if (hour < 24 && min < 60) {
16                if (max.equals("") || s.compareTo(max) > 0) {
17                    max = s;
18                }
19            }
20            return;
21        }
22
23        for (int i = 0; i < arr.length; i++) {
24            if (!used[i]) {
25                used[i] = true;
26                backtrack(arr, used, s + arr[i]);
27                used[i] = false;
28            }
29        }
30    }
31}
32