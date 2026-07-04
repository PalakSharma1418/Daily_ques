// Last updated: 7/4/2026, 2:50:25 PM
1class Solution {
2    public int minSpeedOnTime(int[] dist, double hour) {
3
4        int l = 1;
5        int r = 10000000;
6        int ans = -1;
7
8        while (l <= r) {
9
10            int mid = l + (r - l) / 2;
11
12            if (isPossible(dist, hour, mid)) {
13                ans = mid;
14                r = mid - 1;
15            } else {
16                l = mid + 1;
17            }
18        }
19
20        return ans;
21    }
22
23    public boolean isPossible(int[] dist, double hour, int speed) {
24
25        double total = 0;
26
27        for (int i = 0; i < dist.length - 1; i++) {
28            total += Math.ceil((double) dist[i] / speed);
29        }
30
31        total += (double) dist[dist.length - 1] / speed;
32
33        return total <= hour;
34    }
35}