// Last updated: 1/7/2026, 4:28:40 PM
1class Solution {
2    public List<String> getLongestSubsequence(String[] words, int[] groups) {
3        List<String> ans = new ArrayList<>();
4        int g=groups[0];
5        ans.add(words[0]);
6        for(int i=1;i<groups.length;i++){
7            if(groups[i]!=g){
8                ans.add(words[i]);
9                g=groups[i];
10            }
11        }
12        return ans;
13    }
14}