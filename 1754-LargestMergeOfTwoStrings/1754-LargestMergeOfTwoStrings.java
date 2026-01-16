// Last updated: 1/16/2026, 4:38:11 PM
1class Solution {
2    public String largestMerge(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5        int i =0 , j =0;
6        StringBuilder sb = new StringBuilder();
7        while(i<n && j<m){
8            if(s1.charAt(i)<s2.charAt(j)){
9                sb.append(s2.charAt(j));
10                j++;
11            }
12            else if(s1.charAt(i)>s2.charAt(j)){
13                sb.append(s1.charAt(i));
14                i++;
15            }
16            else{
17                String d = s1.substring(i);
18                String f = s2.substring(j);
19                if(d.compareTo(f)>0){
20                    sb.append(s1.charAt(i));
21                    i++;
22                }else{
23                    sb.append(s2.charAt(j));
24                    j++;
25                }
26            }
27        }
28
29        sb.append(s1.substring(i));
30        sb.append(s2.substring(j));
31        return sb.toString();
32    }
33}