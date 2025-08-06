// Last updated: 8/6/2025, 4:51:27 PM
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                // Check if stack is empty before popping (prevents crash)
                if (st.isEmpty()) {
                    return false;
                }
                
                char d = st.pop();
                
                // Proper bracket matching condition
                if ((ch == ')' && d != '(') || 
                    (ch == ']' && d != '[') || 
                    (ch == '}' && d != '{')) {
                    return false;
                }
            }
        }
        
        // Stack should be empty if all brackets matched
        return st.isEmpty();
    }
}
