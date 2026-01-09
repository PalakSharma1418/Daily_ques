// Last updated: 1/9/2026, 10:57:05 AM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int last=-1;
        for(int i=0; i<n; i++){
            if (nums[i]==1){
                if (last!=-1 && i-last-1<k) return false;
                last=i;
            }
        }
        return true;
    
    }
}