// Last updated: 8/6/2025, 4:51:42 PM
class Solution {
    public boolean isPalindrome(int x) {int s;
        if(x<0){
            return false;
        }
        else{
            int n=x;
            s=0;
            while(n>0){
                s=s*10+n%10;
                n=n/10;
            }
        }
        return s==x;
    }
}