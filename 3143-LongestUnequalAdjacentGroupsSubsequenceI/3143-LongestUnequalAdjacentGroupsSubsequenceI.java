// Last updated: 1/9/2026, 10:53:06 AM
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int g=groups[0];
        ans.add(words[0]);
        for(int i=1;i<groups.length;i++){
            if(groups[i]!=g){
                ans.add(words[i]);
                g=groups[i];
            }
        }
        return ans;
    }
}