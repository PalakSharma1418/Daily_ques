// Last updated: 8/6/2025, 4:42:32 PM
class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        long [] re= new long[n];
        long max=nums[0];
        re[0]=nums[0]+max;
        for(int i=1;i<n;i+=1){
            if(nums[i]>max){
                max=nums[i];
            }
            re[i]=re[i-1]+max+nums[i];
        }
        return re;
    }
}