// Last updated: 2/18/2026, 11:40:07 AM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        int bo = -1;
4        int prev = n&(1);
5        n=n>>1;
6        while(n>0){
7            int curr = n&(1);
8            if(curr==prev){
9                bo=0;
10                break;
11            }
12            prev=curr;
13            n>>=1;
14        }
15        return bo==0?false:true;
16    }
17}