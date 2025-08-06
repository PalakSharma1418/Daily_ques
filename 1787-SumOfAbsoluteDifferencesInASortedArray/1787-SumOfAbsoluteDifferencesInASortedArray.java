// Last updated: 8/6/2025, 4:45:07 PM
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        int n=nums.length;
        for (int i : nums) {
            sum += i;
        }
        int[] result = new int[n];
        int prefixSum = 0;

       for (int i = 0; i < n; i++) {
            int leftSum = prefixSum;
            int rightSum = sum - prefixSum - nums[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = rightSum - (nums[i] * rightCount);

            result[i] = leftTotal + rightTotal;
            prefixSum += nums[i];
        }

        return result;
    }
}