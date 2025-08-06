// Last updated: 8/6/2025, 4:45:08 PM
class Solution {
    public boolean closeStrings(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i=0;i<s1.length();i++){
            f1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            f2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if((f1[i]==0 && f2[i]!=0) || (f1[i]!=0 && f2[i]==0)){
                return false;
            }
        }
        Arrays.sort(f2);
        Arrays.sort(f1);
        for(int i=0;i<26;i++){
            if(f1[i] != f2[i]){
                return false;
            }
        }
        return true;
    }
}