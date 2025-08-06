// Last updated: 8/6/2025, 4:47:51 PM
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res =0;
        int len= nums.length;
        int commonno= nums[len/2];
        for(int num : nums){
        res += Math.abs(commonno - num);
        }
       return res;
    }
}
