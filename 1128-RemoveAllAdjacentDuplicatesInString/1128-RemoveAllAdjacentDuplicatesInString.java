// Last updated: 8/6/2025, 4:46:04 PM
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            boolean t= true;
            while(!st.isEmpty() && st.peek()==s.charAt(i)){
                st.pop();
                t=false;
            }
            if(t){
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}