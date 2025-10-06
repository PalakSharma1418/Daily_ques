// Last updated: 10/6/2025, 7:47:01 PM
class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Character> st = new Stack<>();
        char[] tem=s.toCharArray();
        for(int i=0;i<tem.length;i++){
            st.push(tem[i]);
            if(st.size()>=2*k){
                boolean balance = true;
                for(int j=0;j<k;j++){
                    if(st.get(st.size()-1-j)!=')'){
                        balance=false;
                        break;
                    }
                }
                for(int j=0;j<k && balance;j++){
                    if(st.get(st.size()-1-k-j)!='('){
                        balance=false;
                        break;
                    }
                    
                }
                if(balance){
                    for(int y=0;y<2*k;y++){
                        st.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: st){
            sb.append(c);
        }
        return sb.toString();
    }
}