// Last updated: 1/8/2026, 7:07:29 AM
1class Solution {
2    public int maxRepeating(String sequence, String word) {
3        int k = 0;
4        String temp = word;
5
6        while (sequence.contains(temp)) {
7            k++;
8            temp += word;
9        }
10
11        return k;
12    }
13}
14