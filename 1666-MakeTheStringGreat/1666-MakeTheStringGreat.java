// Last updated: 1/9/2026, 10:56:38 AM

class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                // ASCII difference between lowercase and uppercase of same letter = 32
                st.pop();
            } else {
                st.push(ch);
            }
        }

        // Build final string from stack
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}
