// Last updated: 4/5/2026, 7:36:17 AM
1class Solution {
2    public boolean judgeCircle(String moves) {
3        int u=0 , l=0 , r=0 , d=0;
4        for(char ch : moves.toCharArray()){
5            if(ch=='U') u++;
6            if(ch=='D') d++;
7            if(ch=='R') r++;
8            if(ch=='L') l++;
9        }
10
11        return u==d && r==l;
12    }
13}