// Last updated: 2/11/2026, 3:51:14 PM
1class Solution {
2    public String maxValue(String n, int x) {
3        String ans = "";
4        char xx =(char) (x+'0');
5        boolean flag=true;
6        if(n.charAt(0)=='-'){
7            //chota 
8            for(int i=0 ; i<n.length(); i++){
9                if(n.charAt(i) > xx){
10                    flag=false;
11                    ans+=xx;
12                    ans+=n.substring(i);
13                    break;
14                }
15                else{
16                    ans+=n.charAt(i);
17                }
18            }
19        }
20        else{
21            for(int i=0 ; i<n.length(); i++){
22                if(n.charAt(i) < xx){
23                    flag = false;
24                    ans+=xx;
25                    ans+=n.substring(i);
26                    break;
27                }
28                else{
29                    ans+=n.charAt(i);
30                }
31            }
32        }
33        if(flag){
34            ans+=xx;
35        }
36        return ans;
37    }
38}