// Last updated: 8/6/2025, 4:47:47 PM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int m=-1;
        int s=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                s++;
            }
            else{
                m=Math.max(m,s);
                s=0;
            }
        }
        m=Math.max(m,s);
        return m;
    }
}