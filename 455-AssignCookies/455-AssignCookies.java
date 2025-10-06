// Last updated: 10/6/2025, 6:25:28 AM
class Solution {
    public void reverseString(char[] s) {
        reverse(s ,0, s.length-1);
    }
    public static void reverse(char[] s,int i,int j) {
        if(i>j) return;

        char ch = s[i];
        s[i]=s[j];
        s[j]=ch;
        reverse(s,i+1,j-1);
    }
}