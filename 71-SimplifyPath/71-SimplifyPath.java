// Last updated: 12/11/2025, 7:22:55 PM
1class Solution {
2    public static String simplifyPath(String path) {
3        // Split the path by slash
4        String[] parts = path.split("/");
5        Stack<String> stack = new Stack<>();
6
7        for (String part : parts) {
8            if (part.equals("") || part.equals(".")) {
9                // Skip empty and current directory
10                continue;
11            } else if (part.equals("..")) {
12                // Go up one directory if possible
13                if (!stack.isEmpty()) {
14                    stack.pop();
15                }
16            } else {
17                // Valid directory name, push to stack
18                stack.push(part);
19            }
20        }
21
22        // Build the canonical path
23        StringBuilder result = new StringBuilder();
24        for (String dir : stack) {
25            result.append("/").append(dir);
26        }
27
28        // If the result is empty, it means root directory
29        return result.length() > 0 ? result.toString() : "/";
30    }
31}