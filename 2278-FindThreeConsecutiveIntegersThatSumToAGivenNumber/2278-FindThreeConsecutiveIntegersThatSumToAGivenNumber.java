// Last updated: 8/6/2025, 4:43:38 PM
class Solution {
    public long[] sumOfThree(long num) {
        if(num%3==0){
            long i = (num)/3;
            return new long[]{i-1,i,i+1};
        }
        return new long[0];
    }
}