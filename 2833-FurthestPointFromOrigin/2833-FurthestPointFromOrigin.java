// Last updated: 4/24/2026, 11:14:38 AM
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int l = 0, r = 0, blank = 0;
4        for(int i = 0; i < moves.length(); i++){
5            if(moves.charAt(i) == 'L') l++;
6            else if(moves.charAt(i) == 'R') r++;
7            else blank++;
8        }
9        return Math.abs(l-r) + blank;
10    }
11}