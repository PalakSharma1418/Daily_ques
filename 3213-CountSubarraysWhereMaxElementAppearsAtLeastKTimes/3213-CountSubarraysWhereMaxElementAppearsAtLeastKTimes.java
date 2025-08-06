// Last updated: 8/6/2025, 4:42:06 PM
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int si = 0, ei = 0;
        int countMax = 0;
        long count = 0;

        while (ei < n) {
            if (nums[ei] == max) {
                countMax++;
            }
            while (countMax >= k) {
                count += (n - ei); 
                if (nums[si] == max) {
                    countMax--;
                }
                si++;
            }

            ei++;
        }

        return count;
    }
}
