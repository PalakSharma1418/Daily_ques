// Last updated: 12/24/2025, 11:44:45 AM
1
2class Solution {
3    public int countCollisions(String directions) {
4        int n = directions.length(), ans = 0, l = 0, r = n - 1; 
5        while(l < n && directions.charAt(l) == 'L') l++;
6        while(r >= l && directions.charAt(r) == 'R') r--;
7        for(int i = l ; i <= r; i++) {
8            if(directions.charAt(i) != 'S') ans++;
9        }
10        return ans;
11    }
12}