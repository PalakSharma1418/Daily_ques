// Last updated: 1/18/2026, 8:03:40 AM
1class Solution {
2    public int vowelConsonantScore(String s) {
3        int v =0 ;
4        int c =0;
5        for(int i =0 ; i< s.length() ; i++){
6            char ch = s.charAt(i);
7            if(ch>='a' && ch <='z')
8            {   if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
9                    v++;
10                }else{
11                    c++;
12                }
13            }
14        }
15        if(c>0){
16            return(int)Math.floor(v/c);
17        }
18        return 0 ;
19    }
20}