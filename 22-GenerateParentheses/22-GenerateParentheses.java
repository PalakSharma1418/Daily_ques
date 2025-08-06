// Last updated: 8/6/2025, 4:51:24 PM
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll= new ArrayList<>();
        if(n==1){
            ll.add("()");
            return ll; 
        }
        Parenthesis(n, 0, 0, "",ll);
        return ll;
    }
    public static void Parenthesis(int n,int closed,int open,String ans,List<String> ll) {
        if(open==n && closed==n){
            // System.out.println(ans);
            ll.add(ans);
            return;
        }
        if(open>n || closed>open){
            return;
        }
        Parenthesis(n,closed,open+1,ans+"(",ll);
        Parenthesis(n,closed+1,open,ans+")",ll);
    }
}