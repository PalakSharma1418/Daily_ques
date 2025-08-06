// Last updated: 8/6/2025, 4:42:52 PM
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=num;i>=0;i--){
            if(i+reverse(i)==num){
                return true;
            }
        }
        return false;
    }
    public int reverse(int n){
        int r=0;
        while(n>0){
            r=r*10+n%10;
            n=n/10;
        }
        return r;
    }
}