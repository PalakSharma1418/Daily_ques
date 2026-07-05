// Last updated: 7/5/2026, 3:16:54 PM
1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3
4        // Impossible to make m bouquets
5        if ((long) m * k > bloomDay.length) {
6            return -1;
7        }
8
9        int left = Integer.MAX_VALUE;
10        int right = Integer.MIN_VALUE;
11
12        // Find minimum and maximum bloom day
13        for (int day : bloomDay) {
14            left = Math.min(left, day);
15            right = Math.max(right, day);
16        }
17
18        int ans = -1;
19
20        while (left <= right) {
21            int mid = left + (right - left) / 2;
22
23            if (isPossible(bloomDay, m, k, mid)) {
24                ans = mid;
25                right = mid - 1;
26            } else {
27                left = mid + 1;
28            }
29        }
30
31        return ans;
32    }
33
34    private boolean isPossible(int[] bloomDay, int m, int k, int day) {
35
36        int flowers = 0;
37        int bouquets = 0;
38
39        for (int bloom : bloomDay) {
40
41            if (bloom <= day) {
42                flowers++;
43            }
44            else {
45                flowers = 0;
46            }
47
48            if (flowers == k) {
49                bouquets++;
50                flowers = 0; // Flowers are used, so reset
51            }
52        }
53
54        return bouquets >= m;
55    }
56}