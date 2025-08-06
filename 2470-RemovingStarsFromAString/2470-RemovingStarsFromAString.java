// Last updated: 8/6/2025, 4:43:09 PM
class Solution {
    public String removeStars(String s) {
        StringBuilder n=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='*'){
                n.deleteCharAt(n.length()-1);
            }else{
                n.append(c);
            }
        }
        return n.toString();
    }
}