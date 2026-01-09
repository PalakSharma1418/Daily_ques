// Last updated: 1/9/2026, 10:52:42 AM
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if(k==1) return nums;

        int len = 1; 
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                len++;
            } else {
                len = 1;
            }
            if (i >= k - 1) {//i - k + 1 >= 0
                if (len >= k) {
                    res[i - k + 1] = nums[i];
                } else {
                    res[i - k + 1] = -1;
                }
            }
        }

        return res;
    }
}
