// Last updated: 8/6/2025, 4:48:05 PM
class Solution {
    public int thirdMax(int[] nums) {
        int nl = nums.length;
        if (nl == 3) {
            int a = nums[0];
            int b = nums[1];
            int c = nums[2];
            if (a == b || c == a || b == c) {
                return Math.max(a, Math.max(b, c)); 
            } else {
                return Math.min(a, Math.min(b, c)); 
            }
        } else if (nl < 3) {
            int max = nums[0];
            for (int i = 1; i < nl; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        } else {
             Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) 
                continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
        }
    }
}
