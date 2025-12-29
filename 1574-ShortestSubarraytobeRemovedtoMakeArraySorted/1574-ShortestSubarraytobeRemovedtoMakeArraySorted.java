// Last updated: 12/29/2025, 8:06:35 PM
1class Solution {
2    public int findLengthOfShortestSubarray(int[] arr) {
3        int n = arr.length;
4
5        // Step 1: find sorted prefix
6        int left = 0;
7        while (left + 1 < n && arr[left] <= arr[left + 1]) {
8            left++;
9        }
10
11        // Already sorted
12        if (left == n - 1) return 0;
13
14        // Step 2: find sorted suffix
15        int right = n - 1;
16        while (right > 0 && arr[right - 1] <= arr[right]) {
17            right--;
18        }
19        int ans = Math.min(n - left - 1, right);
20        int i = 0, j = right;
21        while (i <= left && j < n) {
22            if (arr[i] <= arr[j]) {
23                // (i+1) to (j-1)
24                ans = Math.min(ans, j - i - 1);
25                i++;
26            } else {
27                j++;
28            }
29        }
30
31        return ans;
32    }
33}
34