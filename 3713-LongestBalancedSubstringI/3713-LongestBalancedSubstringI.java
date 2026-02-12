// Last updated: 2/12/2026, 7:19:28 AM
1class Solution {
2    public int longestBalanced(String s) {
3        int n =s.length();
4        int m=0;
5        for(int i=0;i<n;i++){
6            int[] fr=new int[26];
7            for(int j=i;j<n;j++){
8                char ch = s.charAt(j);
9                fr[ch-'a']++;
10                if(is(fr)){
11                    m=Math.max(m,j-i+1);
12                }
13            }
14        }
15        return m;
16    }
17    public static boolean is(int[] fr){
18        int c=0;
19        for(int f:fr){
20           if(f>0)
21            {if(c==0) c=f;
22            else if(c!=f) return false;}
23        }
24        return true;
25    }
26}