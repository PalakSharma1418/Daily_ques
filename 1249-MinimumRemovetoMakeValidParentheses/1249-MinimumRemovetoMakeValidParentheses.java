// Last updated: 8/6/2026, 7:35:07 PM
1class Solution {
2    public String minRemoveToMakeValid(String s) {
3        // Initialize counts for left and right parentheses
4        int leftCount = 0;
5        int rightCount = 0;
6
7        // Use a stack to keep track of valid parentheses
8        Stack<Character> stack = new Stack<>();
9
10        // Pass 1: Iterate through the string and process parentheses
11        for (int i = 0; i < s.length(); i++) {
12            char currentChar = s.charAt(i);
13
14            // Increment count for left parentheses
15            if (currentChar == '(') {
16                leftCount++;
17            }
18            // Increment count for right parentheses
19            if (currentChar == ')') {
20                rightCount++;
21            }
22
23            // If there are more right parentheses than left, skip the current right parenthesis
24            if (rightCount > leftCount) {
25                rightCount--; // Decrease right count
26                continue;     // Skip processing this right parenthesis
27            } else {
28                stack.push(currentChar); // Add valid parentheses to the stack
29            }
30        }
31
32        // Pass 2: Reconstruct the string using the valid parentheses in the stack
33        StringBuilder result = new StringBuilder();
34        while (!stack.isEmpty()) {
35            char currentChar = stack.pop();
36            // If there are more left parentheses than right, skip the current left parenthesis
37            if (leftCount > rightCount && currentChar == '(') {
38                leftCount--; // Decrease left count
39                // Do nothing, skip this left parenthesis
40            } else {
41                result.append(currentChar); // Add valid parentheses to the result
42            }
43        }
44
45        // Reverse the result string and return
46        return result.reverse().toString();
47    }
48}