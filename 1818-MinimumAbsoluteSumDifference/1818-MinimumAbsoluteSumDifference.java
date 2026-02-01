// Last updated: 2/1/2026, 1:42:33 PM
1import java.util.*;
2
3class Solution {
4    static final int MOD = 1_000_000_007;
5
6    // Custom lower bound
7    static int lowerBound(int[] arr, int target) {
8        int l = 0, r = arr.length;
9        while (l < r) {
10            int mid = l + (r - l) / 2;
11            if (arr[mid] < target)
12                l = mid + 1;
13            else
14                r = mid;
15        }
16        return l;
17    }
18
19    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
20        int n = nums1.length;
21
22        long total = 0;
23        for (int i = 0; i < n; i++) {
24            total += Math.abs(nums1[i] - nums2[i]);
25        }
26
27        int[] sorted = nums1.clone();
28        Arrays.sort(sorted);
29
30        long maxGain = 0;
31
32        for (int i = 0; i < n; i++) {
33            int a = nums1[i];
34            int b = nums2[i];
35            int currDiff = Math.abs(a - b);
36
37            int idx = lowerBound(sorted, b);
38
39            // candidate at idx
40            if (idx < n) {
41                int newDiff = Math.abs(sorted[idx] - b);
42                maxGain = Math.max(maxGain, currDiff - newDiff);
43            }
44
45            // candidate at idx - 1
46            if (idx > 0) {
47                int newDiff = Math.abs(sorted[idx - 1] - b);
48                maxGain = Math.max(maxGain, currDiff - newDiff);
49            }
50        }
51
52        return (int)((total - maxGain) % MOD);
53    }
54}
55