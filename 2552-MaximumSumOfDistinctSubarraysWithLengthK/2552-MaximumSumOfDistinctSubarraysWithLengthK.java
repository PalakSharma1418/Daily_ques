// Last updated: 8/6/2025, 4:42:50 PM
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] used = new int[100001];  // Adjust size to handle larger numbers
        int i = 0, j = 0;
        long maxSum = 0, sum = 0;

        while (j < nums.length){
            //grow
            sum += nums[j];
            used[nums[j]]++;

            //shrink
            while (used[nums[j]] > 1) {
                sum -= nums[i];
                used[nums[i]]--;
                i++;
            }

            //update
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                used[nums[i]]--;
                i++;
            }

            j++;
        }
        return maxSum;
    }
}