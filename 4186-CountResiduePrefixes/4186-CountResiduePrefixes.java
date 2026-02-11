// Last updated: 2/11/2026, 7:19:47 AM
class Solution {
    public int residuePrefixes(String s) {
        Set<Character> set = new HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            set.add(ch);
            int re = set.size();
            if((i+1)%3==re){
                ans++;
            }
        }
        return ans;
    }
}