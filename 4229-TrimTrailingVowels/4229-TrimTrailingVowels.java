// Last updated: 3/11/2026, 8:00:18 PM
class Solution {
    boolean isvowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    public String trimTrailingVowels(String s) {
        int i = s.length()-1;
        while(i>=0 && isvowel(s.charAt(i))){
            i--;
        }
        return s.substring(0,i+1);
    }
}