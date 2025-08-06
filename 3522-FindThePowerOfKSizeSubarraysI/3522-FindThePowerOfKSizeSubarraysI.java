// Last updated: 8/6/2025, 4:41:42 PM
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int result[]=new int[n-k+1];
        int lo=0;
        int hi=k-1;
        int i=0;
        while(hi<n){
            if(issort(nums,lo,hi)){
                result[i++]=max(nums,lo,hi);
            }
            else{
                result[i++]=-1;
            }
            lo++;
            hi++;
        }
        return result;
    }
    // public static boolean issort(int[] ar,int lo,int hi){
    //     for(int i=lo;i<hi;i++){
    //         if(ar[i]>ar[i+1]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public static int max(int[] ar,int lo,int hi){
        int m=ar[lo];
        for(int i=lo;i<=hi;i++){
            if(ar[i]>m){
                m=ar[i];
            }
        }
        return m;
    }
    public static boolean issort(int[] ar, int lo, int hi) {
    for (int i = lo; i < hi; i++) {
        if (ar[i] + 1 != ar[i + 1]) { // Ensure elements are strictly consecutive
            return false;
        }
    }
    return true;
}

}