// Last updated: 2/11/2026, 7:20:03 AM
class Solution {
    public int finalElement(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];
        if(n==2){
            return Math.max(arr[0],arr[1]);
        }

        int ans= Math.max(arr[0],arr[n-1]);
        return ans;
        
    }
}