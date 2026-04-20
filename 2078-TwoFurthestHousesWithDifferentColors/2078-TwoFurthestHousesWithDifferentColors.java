// Last updated: 4/20/2026, 7:09:43 PM
1class Solution {
2    public int maxDistance(int[] colors) {
3        int n = colors.length;
4        int ans = 0;
5
6        for(int i = 0; i < n; i++){
7            if(colors[i] != colors[0])
8                ans = Math.max(ans, i);
9
10            if(colors[i] != colors[n-1])
11                ans = Math.max(ans, n - 1 - i);
12        }
13
14        return ans;
15    }
16}