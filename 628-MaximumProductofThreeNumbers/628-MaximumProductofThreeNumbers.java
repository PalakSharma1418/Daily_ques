// Last updated: 7/26/2026, 6:42:53 PM
1class Solution {
2    public int maximumProduct(int[] nums) {
3         int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
4        int  min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
5        for (int n : nums) {
6            if (n > max1) {
7                max3 = max2;
8                max2 = max1;
9                max1 = n;
10            } else if (n > max2) {
11                max3 = max2;
12                max2 = n;
13            } else if (n > max3) {
14                max3 = n;
15            }
16
17            if (n < min1) {
18                min2 = min1;
19                min1 = n;
20            } else if (n < min2) {
21                min2 = n;
22            }
23        }
24        // agar negative ho
25        return Math.max(max1*max2*max3, max1*min1*min2);
26    }
27}