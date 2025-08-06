// Last updated: 8/6/2025, 4:47:02 PM
class Solution {
    public String toLowerCase(String s) {
         StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            if((int)s.charAt(i)>=65 && (int)s.charAt(i)<=90)
            {
                sb.append((char)((int)s.charAt(i)+32));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}