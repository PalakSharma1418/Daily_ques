// Last updated: 8/6/2025, 4:50:15 PM
class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int ans=0;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
               int h=arr[st.pop()];
               int r=i;
               if(st.isEmpty()){
                ans= Math.max(ans, h*r);
               }
               else{
                int l= st.peek();
                int area= h*(r-l-1);
                ans=Math.max(area,ans);
               }
            }
            st.push(i);
        }
        int r= arr.length;
        while(!st.isEmpty()){
            int h=arr[st.pop()];
            if(st.isEmpty()){
             ans= Math.max(ans, h*r);
            }
            else{
             int l= st.peek();
             int area= h*(r-l-1);
             ans=Math.max(area,ans);
            }
         }
        return ans;
    }
}