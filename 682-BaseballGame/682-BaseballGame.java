// Last updated: 8/6/2025, 4:47:12 PM
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        int n=operations.length;
        for(int i=0;i<n;i++){
            String ch=operations[i];
            if(ch.equals("D")){
                if(!st.isEmpty()){
                    int el=st.pop();
                st.push(el);
                st.push(el*2);
                }
            }
            else if(ch.equals("C")){
               if(!st.isEmpty()){
                 st.pop();
               }
            }
            else if(ch.equals("+")){
                if(st.size()>=2){
                    int a=st.pop();
                int b=st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
                }
            }
            else{
               st.push(Integer.parseInt(ch));
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}