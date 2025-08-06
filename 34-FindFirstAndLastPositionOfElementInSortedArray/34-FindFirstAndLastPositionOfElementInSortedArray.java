// Last updated: 8/6/2025, 4:51:14 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f=-1,s=-1;
        int [] h= new int[2];
        for(int i=0;i<nums.length;i++){
            if(f==-1 && nums[i]==target){
                f=i;
            }
            else if(nums[i]==target){
                s=i;
            }
        }
        if(s==-1){
             h[0]=f;
             h[1]=f;
        }
        else{    
            h[0]=f;
            h[1]=s;
        }
        return h;
    }
}