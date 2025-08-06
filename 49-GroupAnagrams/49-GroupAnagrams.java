// Last updated: 8/6/2025, 4:50:54 PM
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int [] visited= new int[strs.length];
        Arrays.fill(visited,0);
        for(int i=0;i<strs.length;i++){
             if (visited[i] == 1) continue;
            ArrayList<String> List = new ArrayList<>();
            List.add(strs[i]);
            visited[i] = 1;
            for(int j=i+1;j<strs.length;j++){
                if(isAnagram(strs[i],strs[j]) && visited[j]==0){
                    List.add(strs[j]);
                    visited[j]=1;
                }
            }
            result.add(List);
            
        }
        return result;

    }
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