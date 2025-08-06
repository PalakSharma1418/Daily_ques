// Last updated: 8/6/2025, 4:51:02 PM
class Solution {
    public int trap(int[] height) {
        return Trapping(height);
        
    }
     public static int Trapping(int arr[]){
        int n= arr.length;
        int [] left =new int[n];
        int [] right =new int[n];
        left[0]=arr[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],arr[i]);//prefix concept
        }
        right[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr[i]);//suffix concept
        }
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=Math.min(right[i],left[i])-arr[i];
        }
        return sum;
    } 
}