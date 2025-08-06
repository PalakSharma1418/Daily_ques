// Last updated: 8/6/2025, 4:45:38 PM
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0,ans=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum/k>=threshold){
                ans++;}
        for(int i=k;i<arr.length;i++){
            sum+=arr[i];//grow
            sum-=arr[i-k];//shrink
            if(sum/k>=threshold){
                ans++;
            }
        }
        return ans;
    }
}