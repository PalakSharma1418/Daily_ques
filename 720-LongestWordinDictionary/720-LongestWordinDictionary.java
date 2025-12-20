// Last updated: 12/20/2025, 3:08:40 PM
1class Solution {
2    public String longestWord(String[] words) {
3
4        HashSet<String> hh= new HashSet<>();
5        Arrays.sort(words);
6        String ans="";
7        for(String s:words){
8            if(s.length()==1 || hh.contains(s.substring(0,s.length()-1))){
9                hh.add(s);
10                if(s.length()>ans.length()) ans=s;
11            }
12        }
13        return ans;
14    }
15}