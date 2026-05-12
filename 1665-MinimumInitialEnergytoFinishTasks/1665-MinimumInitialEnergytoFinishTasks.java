// Last updated: 5/12/2026, 7:28:11 PM
1class Solution {
2    public int minimumEffort(int[][] shop) {
3        Arrays.sort(shop, (a, b) -> b[1] - b[0] - (a[1] - a[0]));
4
5        int start = shop[0][1];
6        int bal = shop[0][1] - shop[0][0];
7        int loan = 0;
8
9        for (int i = 1; i < shop.length; i++) {
10            int cost = shop[i][0];
11            int thresh = shop[i][1];
12
13            if (bal < thresh) {
14                loan += thresh - bal;
15                bal = thresh;
16            }
17
18            bal -= cost;
19        }
20
21        return start + loan;
22    }
23}