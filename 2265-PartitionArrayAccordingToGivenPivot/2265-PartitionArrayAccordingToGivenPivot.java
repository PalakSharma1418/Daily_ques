// Last updated: 8/6/2025, 4:43:41 PM
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int []result= new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                result[j++]=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                result[j++]=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                result[j++]=nums[i];
            }
        }
        return result;
    }
}