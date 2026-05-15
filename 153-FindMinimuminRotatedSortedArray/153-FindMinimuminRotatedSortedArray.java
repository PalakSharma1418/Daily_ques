// Last updated: 5/15/2026, 7:46:14 PM
1class Solution {
2    public static int findMin(int []arr) {
3        int low = 0, high = arr.length - 1;
4        int ans = Integer.MAX_VALUE;
5        while (low <= high) {
6            int mid = (low + high) / 2;
7
8            //if left part is sorted:
9            if (arr[low] <= arr[mid]) {
10                // keep the minimum:
11                ans = Math.min(ans, arr[low]);
12                // Eliminate left half:
13                low = mid + 1;
14
15            } else { 
16                ans = Math.min(ans, arr[mid]);
17                high = mid - 1;
18            }
19        }
20        return ans;
21    }
22}
23