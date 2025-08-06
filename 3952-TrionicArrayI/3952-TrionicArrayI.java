// Last updated: 8/6/2025, 4:40:43 PM
class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<3 ) return false;
        for( int p=1; p<n-2; p++){
            if(!inc(nums,0,p)) continue;
            for(int q=p+1 ; q<n-1 ;q++){
                if(dec(nums, p,q) && inc(nums,q,n-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean inc(int nums[] , int s, int e){
        for(int i= s; i<e; i++){
            if(nums[i] >= nums[i+1]) return false;
        }
        return true;
    }
    public boolean dec(int nums[], int s ,int e){
        for(int i=s;i<e;i++){
            if(nums[i]<=nums[i+1]) return false;
        }
        return true;
    }
}