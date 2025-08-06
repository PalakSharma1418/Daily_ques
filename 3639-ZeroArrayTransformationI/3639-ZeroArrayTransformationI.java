// Last updated: 8/6/2025, 4:41:37 PM
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];  
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            diff[left] ++;       // Add val at the start of the range
            diff[right + 1] --;  // Subtract val at the end of the range
        }
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i]; 
            if (currVal < nums[i]) return false;  
        }
        return true;  
    }
}
