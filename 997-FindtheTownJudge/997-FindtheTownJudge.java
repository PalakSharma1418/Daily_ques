// Last updated: 12/30/2025, 10:39:10 AM
1class Solution {
2    public int findJudge(int n, int[][] trust) {
3        if (trust.length == 0 && n == 1) 
4            return 1;
5        int[] count = new int[n + 1];
6        for (int[] person : trust) {
7            count[person[0]]--;
8            count[person[1]]++;
9        }
10
11        for (int person = 0; person < count.length; person++) {
12            if (count[person] == n - 1) return person;
13        }
14        return -1;
15    }
16}