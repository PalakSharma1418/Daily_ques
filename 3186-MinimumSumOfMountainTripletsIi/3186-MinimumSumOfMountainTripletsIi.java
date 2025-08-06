// Last updated: 8/6/2025, 4:42:07 PM
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];

        pre[0] = Integer.MAX_VALUE;
        suff[n-1] = Integer.MAX_VALUE;

        for(int i = 1; i < n - 1; i++){
            pre[i] = Math.min(pre[i-1], nums[i-1]);
        }


        for(int i = n-2; i > 0; i--){
            suff[i] = Math.min(suff[i+1], nums[i+1]);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++){
            if(nums[i] > pre[i] && nums[i] > suff[i]){
                ans = Math.min(ans, nums[i] + pre[i] + suff[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}