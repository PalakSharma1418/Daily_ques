// Last updated: 8/6/2025, 4:48:11 PM
class Solution {
    public int findNthDigit(int n) {
        long strat = 1;
        int len = 1;
        long count = 9;
        while(n>len*count){
            n-=len*count;
            strat*=10;
            count*=10;
            len++;
        }

        //now we need to find the, position of nuumber (n-1)%len;
        long no = strat + (n - 1) / len;
        String s = String.valueOf(no);
        return s.charAt((n - 1) % len) - '0';
    }
}