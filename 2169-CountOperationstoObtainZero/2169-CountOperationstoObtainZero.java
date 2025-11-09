// Last updated: 11/9/2025, 7:46:41 AM
class Solution {
    public int countOperations(int num1, int num2) {
        if(num1==0 || num2==0){
            return 0;
        }
        int c=1;
        while(true){
            if(num1==0 || num2==0){
                return 0;
            }
            if(num1 > num2){
                num1=num1-num2;
                c++;
            }
            if(num1 < num2){
                num2=num2-num1;
                c++;
            }
            if(num1==num2){
                return c;
            }
        }
        //return c;
    }
}