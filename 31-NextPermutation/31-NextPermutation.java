// Last updated: 8/6/2025, 4:51:16 PM
class Solution {
    public void nextPermutation(int[] nums) {
        next_permutation(nums);
    }
    public static void next_permutation(int[] arr){
        int p=-1;
        int n= arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                p=i;
                break;
            }
        }
        if(p==-1){
            reverse(arr, 0, n-1);
            return;
        }
        int q=-1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[p]){
                q=i;
                break;
            }
        }
        //  swap p and q
        int temp=arr[p];
        arr[p]=arr[q];
        arr[q]=temp;
        reverse(arr, p+1, n-1);
    }
    public static void reverse(int arr[],int i,int j){
        while(i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            j--;
            i++;
        }
    }
}

