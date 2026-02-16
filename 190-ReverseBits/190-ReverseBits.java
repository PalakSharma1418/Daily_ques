// Last updated: 2/16/2026, 5:16:32 PM
1class Solution {
2    public int reverseBits(int n) {
3        int res = 0;
4        for(int i=0;i<32;i++){
5            int l = n & 1 ;
6            int t= l<<(31-i);
7            res = res|t;
8            n = n>>1;
9        }
10        return res;
11    }
12}