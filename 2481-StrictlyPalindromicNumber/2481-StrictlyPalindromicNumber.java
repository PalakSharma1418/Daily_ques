// Last updated: 8/6/2025, 4:43:05 PM
// class Solution {
//    public boolean isStrictlyPalindromic(int n) {
//     if(n>3){
//         return false;
//     }
//     return true;
//    }
// }
class Solution {
   public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++){
            long ans=base(n,i);
            String s=Long.toString(ans);
            if(!ispalin(s)){
                return false;
            }
        }
        return true;
    }
    public boolean ispalin(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
     public long base(int n,int b){
        long an=0;
        int p=1;
        while(n>0){
            int rem=n%b;
            an=an+rem*p;
            p*=10;
            n=n/b;
        }
        return an;
     }
}