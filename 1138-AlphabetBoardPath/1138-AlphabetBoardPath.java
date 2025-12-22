// Last updated: 12/22/2025, 2:48:40 PM
1class Solution {
2    public String alphabetBoardPath(String target) {
3        StringBuilder sb=new StringBuilder();
4        int x=0;
5        int y=0;
6        for(char c:target.toCharArray()){
7            int x1=(c-'a')/5;
8            int y1=(c-'a')%5;
9            while(x>x1){
10                sb.append('U');
11                x--;
12            }
13            while(y<y1){
14                sb.append('R');
15                y++;
16            }
17            while(y>y1){
18                sb.append('L');
19                y--;
20            }
21            while(x<x1){
22                sb.append('D');
23                x++;
24            }
25            sb.append('!');
26        }
27        return sb.toString();
28    }
29}