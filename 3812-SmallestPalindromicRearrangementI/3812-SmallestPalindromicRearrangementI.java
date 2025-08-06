// Last updated: 8/6/2025, 4:41:10 PM
class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder ans= new StringBuilder();
        int n=s.length();
        if(n==1){
            return s;
        }
        char ch[]= new char[n/2];
        for(int i=0;i<n/2;i++){
            ch[i]=s.charAt(i);
        }
        Arrays.sort(ch);
        for(int i=0;i<ch.length;i++){
            ans.append(ch[i]);
        }
        if(n%2!=0){
            ans.append(s.charAt(n/2));
        }
        for(int i=ch.length-1;i>=0;i--){
            ans.append(ch[i]);
        }
        return ans.toString();
    }
}