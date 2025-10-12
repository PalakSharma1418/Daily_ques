// Last updated: 10/12/2025, 11:45:03 AM
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