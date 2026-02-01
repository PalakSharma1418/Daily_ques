// Last updated: 2/1/2026, 8:02:09 AM
1class Solution {
2    public int countMonobit(int n) {
3        int c=0;
4        if(n>=0) c++;
5        int v =1;
6        while(v<=n){
7            c++;
8            v=(v<<1)|1;
9        }
10        return c;
11    }
12}