// Last updated: 1/28/2026, 7:45:16 PM
1class Solution {
2    public int[] countRectangles(int[][] rectangles, int[][] points) {
3
4        // height max = 100, so 101 buckets
5        ArrayList<Integer>[] buckets = new ArrayList[101];
6        for (int i = 1; i <= 100; i++) {
7            buckets[i] = new ArrayList<>();
8        }
9
10        // put rectangle lengths into height buckets
11        for (int[] r : rectangles) {
12            int l = r[0];
13            int h = r[1];
14            buckets[h].add(l);
15        }
16
17        // sort each bucket (needed for binary search)
18        for (int i = 1; i <= 100; i++) {
19            Collections.sort(buckets[i]);
20        }
21
22        int n = points.length;
23        int[] ans = new int[n];
24
25        // process each point
26        for (int i = 0; i < n; i++) {
27            int x = points[i][0];
28            int y = points[i][1];
29
30            int count = 0;
31
32            // check all heights >= y
33            for (int h = y; h <= 100; h++) {
34                ArrayList<Integer> list = buckets[h];
35                if (list.isEmpty()) continue;
36
37                // count of lengths >= x
38                int idx = lowerBound(list, x);
39                count += list.size() - idx;
40            }
41
42            ans[i] = count;
43        }
44
45        return ans;
46    }
47
48    // first index where value >= target
49    private int lowerBound(ArrayList<Integer> list, int target) {
50        int l = 0, r = list.size();
51        while (l < r) {
52            int mid = (l + r) / 2;
53            if (list.get(mid) < target)
54                l = mid + 1;
55            else
56                r = mid;
57        }
58        return l;
59    }
60}
61