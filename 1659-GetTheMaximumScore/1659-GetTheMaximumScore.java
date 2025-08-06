// Last updated: 8/6/2025, 4:45:14 PM
class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long SUM=0, sum1 = 0, sum2 = 0;
        int i = 0, j = 0;
        int mod=1000000007;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                SUM += Math.max(sum1, sum2) + nums1[i]; // Add the common element
                SUM=SUM%mod;
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            sum1 += nums1[i++];
        }
        while (j < nums2.length) {
            sum2 += nums2[j++];
        }

        SUM += Math.max(sum1, sum2);
        return (int)(SUM%mod);
    }
}