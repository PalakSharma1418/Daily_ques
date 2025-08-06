// Last updated: 8/6/2025, 4:42:36 PM
class Solution {
    public int maxScore(int[] nums) {
     Arrays.sort(nums);
     long m=0;
     int ans=0;
     for(int i= nums.length-1;i>=0;i--){
         m+=nums[i];
        if(m>0){
           ans++;
        }
        else{
            break;
        }
     }   
     return ans;
    }
}
