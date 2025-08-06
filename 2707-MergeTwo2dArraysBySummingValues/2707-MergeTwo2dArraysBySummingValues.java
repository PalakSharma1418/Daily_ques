// Last updated: 8/6/2025, 4:42:25 PM
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        List<int[]> ans = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i][0] < nums2[j][0]) {
                ans.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                ans.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            } else {
                ans.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while (i < n) {
            ans.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }

        while (j < m) {
            ans.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        return ans.toArray(new int[ans.size()][1]);
    }
}