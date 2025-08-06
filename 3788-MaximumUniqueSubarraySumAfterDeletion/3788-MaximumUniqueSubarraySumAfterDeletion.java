// Last updated: 8/6/2025, 4:41:16 PM
class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                set.add(nums[i]);
            }
        }
        if(set.isEmpty()){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        int sum=0;
        for(int n:set){
            sum+=n;
        }
        return sum;
    }
}