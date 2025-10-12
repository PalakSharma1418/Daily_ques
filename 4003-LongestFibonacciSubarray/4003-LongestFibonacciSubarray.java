// Last updated: 10/12/2025, 11:45:12 AM
class Solution {
    public int longestSubarray(int[] nums) {
        int n =nums.length;
        if(n<3) return n;
        int ans=2;
        int l=0,r=2;
        int a=nums[0],b=nums[1];
        while(r<n){
            int c=nums[r];
            if(a+b==c){
                ans=Math.max(ans,r-l+1);
                a=b;
                b=c;
            }
            else{
                l=r-1;
                a=nums[l];
                b=nums[r];
                
            }
            r++;
        }
        return ans;
    }
}