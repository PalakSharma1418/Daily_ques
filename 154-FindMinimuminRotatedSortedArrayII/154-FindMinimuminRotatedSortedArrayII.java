// Last updated: 5/16/2026, 12:31:48 PM
1class Solution {
2    public int findMin(int[] arr) {
3        int low = 0, high = arr.length - 1;
4        int ans = Integer.MAX_VALUE;
5
6        while (low <= high) {
7
8            int mid = (low + high) / 2;
9
10            // duplicates
11            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
12                ans = Math.min(ans, arr[mid]);
13                low++;
14                high--;
15            }
16
17            // left half sorted
18            else if (arr[low] <= arr[mid]) {
19                ans = Math.min(ans, arr[low]);
20                low = mid + 1;
21            }
22
23            // right half sorted
24            else {
25                ans = Math.min(ans, arr[mid]);
26                high = mid - 1;
27            }
28        }
29
30        return ans;
31    }
32}