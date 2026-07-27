// Last updated: 7/27/2026, 8:11:28 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3         int max1 = 0, max2 = 0;
4        for (int num : nums) {
5            if (num > max1) {
6                max2 = max1;
7                max1 = num;
8            } else if (num > max2) {
9                max2 = num;
10            }
11        }
12        return (max1 - 1) * (max2 - 1);
13    }
14}