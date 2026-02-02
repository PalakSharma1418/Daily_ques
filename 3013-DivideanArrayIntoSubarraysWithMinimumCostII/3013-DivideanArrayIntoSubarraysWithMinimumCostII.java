// Last updated: 2/2/2026, 8:19:52 PM
1
2class Solution {
3    public long minimumCost(int[] nums, int k, int dist) {
4        int n = nums.length;
5
6        // Sort by value first, then index
7        TreeSet<int[]> kMinimum = new TreeSet<>((a, b) -> {
8            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
9            return Integer.compare(a[1], b[1]);
10        });
11
12        TreeSet<int[]> remaining = new TreeSet<>((a, b) -> {
13            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
14            return Integer.compare(a[1], b[1]);
15        });
16
17        long sum = 0;   // sum of (k-1) smallest in window
18
19        int i = 1;
20
21        // Build first window [1 ... dist+1]
22        while (i < n && i - dist < 1) {
23            int[] cur = new int[]{nums[i], i};
24            kMinimum.add(cur);
25            sum += nums[i];
26
27            if (kMinimum.size() > k - 1) {
28                int[] largest = kMinimum.pollLast();
29                sum -= largest[0];
30                remaining.add(largest);
31            }
32            i++;
33        }
34
35        long result = Long.MAX_VALUE;
36
37        // Sliding window
38        while (i < n) {
39            int[] cur = new int[]{nums[i], i};
40            kMinimum.add(cur);
41            sum += nums[i];
42
43            if (kMinimum.size() > k - 1) {
44                int[] largest = kMinimum.pollLast();
45                sum -= largest[0];
46                remaining.add(largest);
47            }
48
49            result = Math.min(result, sum);
50
51            // Remove expired index (i - dist)
52            int remIdx = i - dist;
53            int[] toRemove = new int[]{nums[remIdx], remIdx};
54
55            if (kMinimum.remove(toRemove)) {
56                sum -= nums[remIdx];
57
58                if (!remaining.isEmpty()) {
59                    int[] promote = remaining.pollFirst();
60                    kMinimum.add(promote);
61                    sum += promote[0];
62                }
63            } else {
64                remaining.remove(toRemove);
65            }
66
67            i++;
68        }
69
70        return nums[0] + result;
71    }
72}