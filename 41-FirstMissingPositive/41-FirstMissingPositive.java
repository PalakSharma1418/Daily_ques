// Last updated: 8/6/2025, 4:51:04 PM
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int arr[]= new int[n];
        Arrays.fill(arr, -1);
        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<=n)
            {
             arr[nums[i]-1]=1;
            }
        }
        for(int j=0;j<n;j++){
            if(arr[j]==-1){
                return j+1;
            }
        }
        return n+1;
    }
}