// Last updated: 8/6/2025, 4:46:31 PM
class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums,0,nums.length-1);
    }
    public static int[] sort(int [] arr,int si,int ei){
        if(si==ei){
            int [] bs= new int[1];
            bs[0]=arr[si];
            return bs;
        }

        int mid=(si+ei)/2;
        int [] a= sort(arr, si, mid);
        int [] b=sort(arr, mid+1, ei);
        return merge_sort(a, b);
    }
    public static int[] merge_sort(int[] arr1, int[] arr2){
        int n= arr1.length;
        int m= arr2.length;
        int [] ans= new int[n+m];
        int i=0,j=0,k=0;
        while (i<n && j<m) {
            if(arr1[i]<arr2[j]){
                ans[k++]=arr1[i++];
            }
            else{
                ans[k++]=arr2[j++];
            }
        }
        while(i<n){
            ans[k++]=arr1[i];
            i++;
        }
        while(j<m){
            ans[k++]=arr2[j];
            j++;
        }
        return ans;
    }
}