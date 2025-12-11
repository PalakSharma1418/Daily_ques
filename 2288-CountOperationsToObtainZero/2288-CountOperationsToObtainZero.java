// Last updated: 12/11/2025, 7:35:16 AM
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