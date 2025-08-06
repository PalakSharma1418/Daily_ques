// Last updated: 8/6/2025, 4:43:33 PM
class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        boolean f=true;
        while(f){
            nums =sum(nums);
            if(nums.length==1){
                f=false;
            }

        }
        return nums[0];
    }
    public int[] sum(int[] nums){
        int n=nums.length;
        int []re=  new int[n-1];
        for(int i=0;i<n-1;i++){
            re[i]=(nums[i]+nums[i+1])%10;
        }
        return re;
    }
}