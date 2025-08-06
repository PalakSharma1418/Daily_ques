// Last updated: 8/6/2025, 4:49:19 PM
class Solution {
    public void rotate(int[] nums, int k) {
        Rotate(nums,k);
    }
    public static void Rotate(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        // staring n-k Reverse kro
        Reverse(arr,0,n-k-1);
        // last ke k Reverse kro
        Reverse(arr,n-k,n-1);
        //all elemnet reverse kro
        Reverse(arr,0,n-1);
    }
    public static void Reverse(int[] arr ,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}