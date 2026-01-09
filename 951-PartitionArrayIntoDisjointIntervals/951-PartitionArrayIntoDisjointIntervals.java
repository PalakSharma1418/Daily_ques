// Last updated: 1/9/2026, 10:58:37 AM
class Solution {
    public int partitionDisjoint(int[] nums) {
      int n = nums.length; 
      int left_max[] =  new int[n];
      int right_min[]= new int[n];
      left_max[0]=nums[0];
      for(int i=1; i< n ;i++){
            left_max[i]=Math.max(left_max[i-1],nums[i-1]);
      }
      right_min[n-1]=nums[n-1];
      for(int i=n-2; i>=0 ;i--){
         right_min[i]=Math.min(right_min[i+1],nums[i+1]);
      }

      for(int i=0; i< n ;i++){
         System.out.println(left_max[i]+" i "+right_min[i]);
      }
      
        int ans=0;
        for(int i=0; i<n;i++){
            if(left_max[i]<= right_min[i]){
                ans=i;
                break;
            }
        }
      return ans+1;
    }
}