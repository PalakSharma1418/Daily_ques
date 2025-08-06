// Last updated: 8/6/2025, 4:48:08 PM
class Solution {
    public int splitArray(int[] nums, int k) {
        return minTime(nums,k);
    }
    public static int minTime(int[] arr,int nop){
        int lo=0;
        int hi=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            hi+=arr[i];
        }
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isItPossible(arr,nop,mid)){
                hi=mid-1;
                ans=mid;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isItPossible(int[] arr,int nop,int mid){
        int painter=1;
        int painted=0;
        int i=0;
        while(i<arr.length){
            if(painted+arr[i]<=mid){
                painted+=arr[i];
                i++;
            }
            else{
                painter++;
                painted=0;
            }
            if(painter>nop){
                return false;
            }
        }
        return true;
    }
}