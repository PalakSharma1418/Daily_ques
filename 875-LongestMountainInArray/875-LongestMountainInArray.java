// Last updated: 8/6/2025, 4:46:50 PM
class Solution {
    public int longestMountain(int[] arr) {
        int n= arr.length;
        if(n<3) return 0;
        int i=1;
        int longest=0;
        while(i<n-1){
            boolean peak= ((arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1]));
            if(peak){
                int left =i;
                int right=i;
                while(left>0 && arr[left]>arr[left-1]){
                    left--;
                }
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                
                int currLen = right - left + 1;
                longest = Math.max(longest, currLen);

                // Skip to end of the right mountain. kyuki uske bech mai thosi koi rise hoga agar hota to vhi phela mountain khatma ho jata
                i = right;
            }
            else {
                i++; // Search peak in next element.
            }
        }
        return longest;
    }
}