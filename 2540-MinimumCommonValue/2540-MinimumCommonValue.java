// Last updated: 12/26/2025, 12:28:31 PM
1public class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        Set<Integer> set1 = new HashSet<>();
4
5        for (int num : nums1) {
6            set1.add(num);
7        }
8
9        for (int num : nums2) {
10            if (set1.contains(num)) {
11                return num;
12            }
13        }
14
15        return -1;
16    }
17}