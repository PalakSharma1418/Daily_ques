// Last updated: 8/6/2025, 4:40:56 PM
class Solution {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack= new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && isvalid(stack.peek(),ch)){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public boolean isvalid(char a, char b){
        int d= Math.abs(a-b);
        return d==1 || d==25;
    }
}