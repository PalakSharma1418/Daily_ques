// Last updated: 8/6/2025, 4:41:48 PM
import java.util.*;
class Solution {
    public String compressedString(String word) {
        StringBuilder sb= new StringBuilder();
        int c=1;int i=0;
        for(;i<word.length()-1;i++){
            if(c<9 && word.charAt(i)==word.charAt(i+1)){
                // System.out.println('a');
                c++;
            }
            else
            {  
                sb.append(c);
                sb.append(word.charAt(i)); c=1;
            }
        }
        sb.append(c);
        sb.append(word.charAt(i));
    return sb.toString();
    }
}