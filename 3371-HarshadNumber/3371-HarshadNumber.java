// Last updated: 8/6/2025, 4:42:00 PM
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s=0,n=x;
        while(x>0){
            s+=x%10;
            x=x/10;
        }
        if(n%s==0){
            return s;
        }
        return -1;

    }
}