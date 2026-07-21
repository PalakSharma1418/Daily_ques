// Last updated: 7/21/2026, 5:25:44 PM
1class Solution {
2    public int scoreOfParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(0);   // Base score
5
6        for(char ch : s.toCharArray()) {
7            if(ch == '(') {
8                stack.push(0);
9            }
10            else {
11                int v = stack.pop();
12                if(v == 0)
13                    v = 1;      // ()
14                else
15                    v = 2 * v;  // (A)
16                stack.push(stack.pop() + v);
17            }
18        }
19
20        return stack.pop();
21    }
22}