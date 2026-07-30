// Last updated: 7/30/2026, 6:42:00 PM
1class Solution {
2    public int minimumPushes(String word) {
3        int ans = 0;
4        for(int i = 0; i < word.length(); i++)
5            ans += (i / 8) + 1;
6        return ans;
7    }
8}