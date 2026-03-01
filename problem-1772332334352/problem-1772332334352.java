// Last updated: 3/1/2026, 8:02:14 AM
1class Solution {
2    boolean isvowel(char ch){
3        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
4    }
5    public String trimTrailingVowels(String s) {
6        int i = s.length()-1;
7        while(i>=0 && isvowel(s.charAt(i))){
8            i--;
9        }
10        return s.substring(0,i+1);
11    }
12}