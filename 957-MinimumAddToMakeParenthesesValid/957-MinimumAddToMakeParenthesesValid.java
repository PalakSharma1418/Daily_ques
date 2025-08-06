// Last updated: 8/6/2025, 4:46:28 PM
class Solution {
    public int minAddToMakeValid(String s) {
        int o=0,c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(o>0)
                {o--;
                }
                else{
                    c++;
                }
                
            }
            else if(s.charAt(i)=='('){
                o++;
            }
        }
        return o+c;
    }
}