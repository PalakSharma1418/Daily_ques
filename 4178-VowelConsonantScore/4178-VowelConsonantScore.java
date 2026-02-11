// Last updated: 2/11/2026, 7:19:54 AM
class Solution {
    public int vowelConsonantScore(String s) {
        int v =0 ;
        int c =0;
        for(int i =0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch <='z')
            {   if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    v++;
                }else{
                    c++;
                }
            }
        }
        if(c>0){
            return(int)Math.floor(v/c);
        }
        return 0 ;
    }
}