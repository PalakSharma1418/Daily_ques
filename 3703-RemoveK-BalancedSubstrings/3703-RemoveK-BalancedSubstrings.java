// Last updated: 12/29/2025, 7:14:45 PM
1class Solution {
2    public String removeSubstring(String s, int k) {
3        Stack<Character> st = new Stack<>();
4        char[] tem=s.toCharArray();
5        for(int i=0;i<tem.length;i++){
6            st.push(tem[i]);
7            if(st.size()>=2*k){
8                boolean balance = true;
9                for(int j=0;j<k;j++){
10                    if(st.get(st.size()-1-j)!=')'){
11                        balance=false;
12                        break;
13                    }
14                }
15                for(int j=0;j<k && balance;j++){
16                    if(st.get(st.size()-1-k-j)!='('){
17                        balance=false;
18                        break;
19                    }
20                    
21                }
22                if(balance){
23                    for(int y=0;y<2*k;y++){
24                        st.pop();
25                    }
26                }
27            }
28        }
29        StringBuilder sb = new StringBuilder();
30        for(char c: st){
31            sb.append(c);
32        }
33        return sb.toString();
34    }
35}