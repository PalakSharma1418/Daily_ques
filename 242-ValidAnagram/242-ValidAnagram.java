// Last updated: 8/6/2025, 4:48:51 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int [] sa= new int[26];
        int [] ta= new int[26];
        for(int i=0;i<s.length();i++){
            sa[s.charAt(i)-'a']++;
            ta[t.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(sa[i]!=ta[i]){
                return false;
            }
        }
        return true;
    }
}