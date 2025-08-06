// Last updated: 8/6/2025, 4:46:01 PM
class Solution {
    public void duplicateZeros(int[] arr) {
        int n= arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0 && i+1<n){
                for(int j=n-1;j>i;j--){
                    arr[j]=arr[j-1];
                } 
                i++;
                arr[i]=0;
                if (i >= n) break;
            }
        }
    }
}