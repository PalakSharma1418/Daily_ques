// Last updated: 8/6/2025, 4:51:45 PM
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if(ispallidrom(s)){
            return s;
        }
        int si=-1,e=-1;
         for(int len=1; len<=s.length();len++){
            for(int j=len;j<=s.length();j++){
                int i=j-len;
                if(ispallidrom(s.substring(i, j)))
                {
                    si=i;
                    e=j;
                }
            }
        }
    return s.substring(si,e);
    }
    public static boolean ispallidrom(String s1){
        int i=0;
        int j=s1.length()-1;
        while(i<j){
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            } i++;
            j--;
        }
        return true;
       
    }
}