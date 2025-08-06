// Last updated: 8/6/2025, 4:50:27 PM
class Solution {
    public void sortColors(int[] nums) {
        int r=0,b=0,w=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                r++;
            }
            else if(nums[i]==1){
                w++;
            }
            else{
                b++;
            }
        }
        for(int i =0;i<r;i++){
            nums[i]=0;
        }
        for(int i = r;i<w+r;i++){
            nums[i]=1;
        }
        for(int i= w+r;i<nums.length;i++){
            nums[i]=2;
        }
    }
}