// Last updated: 1/11/2026, 8:04:34 AM
1class Solution {
2    public int residuePrefixes(String s) {
3        Set<Character> set = new HashSet<>();
4        int ans=0;
5        for(int i=0;i<s.length();i++){
6            char ch = s.charAt(i);
7            set.add(ch);
8            int re = set.size();
9            if((i+1)%3==re){
10                ans++;
11            }
12        }
13        return ans;
14    }
15}