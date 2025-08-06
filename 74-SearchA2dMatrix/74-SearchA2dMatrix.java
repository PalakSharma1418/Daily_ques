// Last updated: 8/6/2025, 4:50:29 PM
class Solution {
    public static boolean searchMatrix(int[][] arr, int target) {
        int i;
        int row=arr.length;
        int col=arr[0].length-1;
        for(i=0;i<row;i++){
            if(arr[i][col]>=target){
                break;
            }
        }
        if(i<row){
            return binary_search(arr[i],target);
        }
        else{
            return false;
        }

    }
    public static boolean binary_search(int[] arr,int item){
        int low=0;
        int high=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==item){
                return true;
            }
            else if(arr[mid]>item){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}