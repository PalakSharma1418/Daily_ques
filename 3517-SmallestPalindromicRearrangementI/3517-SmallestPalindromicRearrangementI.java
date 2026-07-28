// Last updated: 7/28/2026, 7:37:17 PM
1class Solution {
2    public String smallestPalindrome(String s) {
3        StringBuilder ans= new StringBuilder();
4        int n=s.length();
5        if(n==1){
6            return s;
7        }
8        char ch[]= new char[n/2];
9        for(int i=0;i<n/2;i++){
10            ch[i]=s.charAt(i);
11        }
12        Arrays.sort(ch);
13        for(int i=0;i<ch.length;i++){
14            ans.append(ch[i]);
15        }
16        if(n%2!=0){
17            ans.append(s.charAt(n/2));
18        }
19        for(int i=ch.length-1;i>=0;i--){
20            ans.append(ch[i]);
21        }
22        return ans.toString();
23    }
24}