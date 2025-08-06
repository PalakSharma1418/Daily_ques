// Last updated: 8/6/2025, 4:50:32 PM
class Solution {
    public static String simplifyPath(String path) {
        // Split the path by slash
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty and current directory
                continue;
            } else if (part.equals("..")) {
                // Go up one directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name, push to stack
                stack.push(part);
            }
        }

        // Build the canonical path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If the result is empty, it means root directory
        return result.length() > 0 ? result.toString() : "/";
    }
}