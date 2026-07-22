// Last updated: 7/22/2026, 8:49:28 AM
1class Solution {
2    public int longestValidParentheses(String s) {
3
4        Stack<Integer> stack = new Stack<>();
5        stack.push(-1);
6
7        int max = 0;
8
9        for (int i = 0; i < s.length(); i++) {
10            if (s.charAt(i) == '(') {
11                stack.push(i);
12            } 
13            else {
14                stack.pop();
15                if (stack.isEmpty()) {
16                    stack.push(i);
17                } else {
18                    max = Math.max(max, i - stack.peek());
19                }
20            }
21        }
22
23        return max;
24    }
25}