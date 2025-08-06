// Last updated: 8/6/2025, 4:41:30 PM
class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        if(Arrays.equals(arr,brr)){
            return 0;
        }
        int n = arr.length;
        if(n==1){
            int r= Math.abs(arr[0] - brr[0]);
        return r;}
        long cost1=0;
        long cost2=0;
        for(int i=0;i<n;i++){
            cost1+=Math.abs(arr[i]-brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0;i<n;i++){
            cost2+=Math.abs(arr[i]-brr[i]);
        }
        return Math.min(cost2+k,cost1);
    }
}