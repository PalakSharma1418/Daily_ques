// Last updated: 2/17/2026, 7:09:10 PM
1class Solution {
2    public List<String> readBinaryWatch(int k) {
3        if (k == 0) return List.of("0:00"); 
4        if (k >= 9) return new ArrayList<>();
5        List<String> res = new ArrayList<>();
6        int mask = (1 << 6) - 1, q = (1 << k) - 1, limit = q << (10 - k);
7
8        while (q <= limit) {
9            int minute = q & mask, hour = q >> 6;
10            is_valid(minute, hour, res);
11            int r = q & -q, n = q + r;
12            q = (((q ^ n) / r) >> 2) | n;
13        }
14
15        return res;
16    }
17
18    public void is_valid(int minute, int hour, List<String> res) {
19        if (hour <= 11 && minute <= 59) {
20            res.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
21        }
22    }
23}