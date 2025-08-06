// Last updated: 8/6/2025, 4:46:45 PM
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length==3){
            return 1;
        }
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid] < arr[mid + 1]){
                low=mid+1;
            }
            else {
                high=mid;
            }
        }
        return low;
    }
}