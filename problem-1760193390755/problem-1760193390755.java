// Last updated: 10/11/2025, 8:06:30 PM
class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int arr[]= new int[n];
        arr[0]=s.charAt(0)-'a'+1;
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+(s.charAt(i)-'a'+1);
        }
        int t=arr[n-1];
        for(int i=0;i<n;i++){
            int l= arr[i];
            int r=t-l;
            if(l==r) return true;
        }
        return false;
    }
}