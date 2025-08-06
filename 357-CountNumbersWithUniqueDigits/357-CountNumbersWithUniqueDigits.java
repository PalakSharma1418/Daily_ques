// Last updated: 8/6/2025, 4:48:27 PM
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int uniquedig=9,avadigi=9,count=10;
        for(int i=1;i<n;i++){
            uniquedig*=avadigi;
            count+=uniquedig;
            avadigi--;
        }
        return count;
    }
}