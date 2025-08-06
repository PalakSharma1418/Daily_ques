// Last updated: 8/6/2025, 4:48:10 PM
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        Stack<Character> st = new Stack<>();

        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // Remove remaining digits if needed
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
