// Last updated: 1/9/2026, 10:52:53 AM
class Solution {
    public long minEnd(int n, int x) {
        long num=x;
        for(int i=1;i<n;i++){
            num=(num+1)|x;
        }
        return num;
    }
}