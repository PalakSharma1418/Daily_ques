// Last updated: 8/6/2025, 4:48:54 PM
class Solution {
    public int[] productExceptSelf(int[] nums) {
        return productExceptSelf1(nums);
    }
    public static int[] productExceptSelf1(int arr[]){
        int n= arr.length;
        int [] left =new int[n];
        int [] right =new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*arr[i-1];//prefix concept
        }
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*arr[i+1];//sufix concept
        }
        int product[]= new int[n];
        for(int i=0;i<n;i++){
            product[i]= left[i]*right[i];
        }
        return product;
    } 
}