// Last updated: 8/6/2025, 4:43:13 PM
class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int left = 1;
        int right = n;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long required = (long) mid * (mid + 1) / 2;

            if (required <= n) {
                ans = mid;          // mid is a valid group count
                left = mid + 1;     // try for more
            } else {
                right = mid - 1;    // too many students needed
            }
        }

        return ans;
    }
}