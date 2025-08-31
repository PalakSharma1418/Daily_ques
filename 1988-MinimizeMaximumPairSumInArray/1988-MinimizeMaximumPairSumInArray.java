// Last updated: 8/31/2025, 4:27:05 PM
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int mx=0;
        while(i<j){
            int sum=nums[i]+nums[j];
            mx=Math.max(mx,sum);
            i++;
            j--;
        }
        return mx;
    }
}