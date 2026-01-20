// Last updated: 1/20/2026, 7:32:42 PM
1import java.util.*;
2
3class Solution {
4
5    // Equivalent of find_number_of_subarrays
6    private long findNumberOfSubarrays(long l, long r, long k) {
7        l = l - 1;
8        r = Math.min(k, r);
9
10        long c1 = r;
11
12        long c2Elements = (l >= k - r) ? (k - r) : l;
13        long c2 = r * c2Elements;
14
15        long leftSubArrRemainElements =
16                (l >= c2Elements) ? (l - c2Elements) : 0;
17
18        long c3 = Math.max(
19                ((r - 1) * r / 2)
20                        - ((r - leftSubArrRemainElements - 1)
21                        * (r - leftSubArrRemainElements) / 2),
22                0
23        );
24
25        if (leftSubArrRemainElements >= r - 1) {
26            c3 = (r - 1) * r / 2;
27        }
28
29        return c1 + c2 + c3;
30    }
31
32    // Equivalent of sum_of_subarray_mins_or_maxs_atmostK
33    private long sumOfSubarrayMinsOrMaxsAtMostK(
34            int[] arr, int k, boolean isMinSubarrSum) {
35
36        Deque<Integer> stack = new ArrayDeque<>();
37        long ans = 0;
38        int n = arr.length;
39
40        for (int ind = 0; ind < n; ind++) {
41            int num = arr[ind];
42
43            while (!stack.isEmpty() &&
44                    (isMinSubarrSum
45                            ? arr[stack.peekLast()] > num
46                            : arr[stack.peekLast()] < num)) {
47
48                int poppedInd = stack.pollLast();
49                int leftCertainInd =
50                        stack.isEmpty() ? 0 : stack.peekLast() + 1;
51
52                long leftSubArray = poppedInd + 1L - leftCertainInd;
53                long rightSubArray = ind - poppedInd;
54
55                ans += findNumberOfSubarrays(
56                        leftSubArray, rightSubArray, k
57                ) * arr[poppedInd];
58            }
59            stack.addLast(ind);
60        }
61
62        while (!stack.isEmpty()) {
63            int poppedInd = stack.pollLast();
64            int leftCertainInd =
65                    stack.isEmpty() ? 0 : stack.peekLast() + 1;
66
67            long leftSubArray = poppedInd + 1L - leftCertainInd;
68            long rightSubArray = n - poppedInd;
69
70            ans += findNumberOfSubarrays(
71                    leftSubArray, rightSubArray, k
72            ) * arr[poppedInd];
73        }
74
75        return ans;
76    }
77
78    // Main function
79    public long minMaxSubarraySum(int[] arr, int k) {
80        return sumOfSubarrayMinsOrMaxsAtMostK(arr, k, true)
81             + sumOfSubarrayMinsOrMaxsAtMostK(arr, k, false);
82    }
83}
84