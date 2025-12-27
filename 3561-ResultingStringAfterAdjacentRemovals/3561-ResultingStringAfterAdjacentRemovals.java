// Last updated: 12/27/2025, 4:23:15 PM
1class Solution {
2    public String resultingString(String s) {
3        StringBuilder sb = new StringBuilder();
4        Stack<Character> stack= new Stack<>();
5        for(char ch : s.toCharArray()){
6            if(!stack.isEmpty() && isvalid(stack.peek(),ch)){
7                stack.pop();
8            }
9            else{
10                stack.push(ch);
11            }
12        }
13        while(!stack.isEmpty()){
14            sb.append(stack.pop());
15        }
16        return sb.reverse().toString();
17    }
18    public boolean isvalid(char a, char b){
19        int d= Math.abs(a-b);
20        return d==1 || d==25;
21    }
22}