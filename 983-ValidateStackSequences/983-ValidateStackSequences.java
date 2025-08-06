// Last updated: 8/6/2025, 4:46:23 PM
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st= new Stack<>();
        int j=0;
        for(int i=0;i<=pushed.length;i++){
            while(!st.isEmpty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
            if(i==pushed.length) break;
            st.push(pushed[i]);
        }
        return st.isEmpty();
    }
}
