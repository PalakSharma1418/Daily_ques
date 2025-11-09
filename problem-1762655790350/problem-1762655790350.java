// Last updated: 11/9/2025, 8:06:30 AM
class Solution {
    public int minimumDistance(int[] nums) {
        int  n = nums.length;
        int ans=Integer.MAX_VALUE;
        boolean f=false;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        int d=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        ans=Math.min(d,ans);
                        f=true;
                    }
                }
            }
        }
            if(!f) return -1;
            return ans;
        
    }
}