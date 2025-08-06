// Last updated: 8/6/2025, 4:51:41 PM
class Solution {
    public int maxArea(int[] arr) {
       int sum=0;
       int left=0;
       int right=arr.length-1;
       while(left < right){
        int s=(right-left)*Math.min (arr[left],arr[right]);
        sum = Math.max(sum,s);
        if(arr[left]<arr[right]){
            left++;
        }
        else{
            right--;
        }
       }
        return sum;
    }
}