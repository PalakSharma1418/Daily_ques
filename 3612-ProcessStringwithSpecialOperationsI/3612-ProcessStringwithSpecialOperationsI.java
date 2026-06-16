// Last updated: 6/16/2026, 5:12:25 PM
1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb = new StringBuilder();
4        for(char ch : s.toCharArray()){
5            if(ch >= 'a' && ch <= 'z'){
6                sb.append(ch);
7            }
8            if(ch=='#'){
9                sb.append(sb);
10            }
11            if(ch=='%'){
12                sb = sb.reverse();
13            }
14            if(ch=='*'){
15                if (sb.length() != 0) {
16                    sb.deleteCharAt(sb.length() - 1);
17                }
18            }
19        }
20        return sb.toString();
21    }
22}