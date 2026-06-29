// Last updated: 6/29/2026, 9:20:11 AM
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3       int c=0 ;
4       for(String s : patterns){
5        if(word.contains(s)){
6            c++;
7        }
8       } 
9       return c;
10    }
11}