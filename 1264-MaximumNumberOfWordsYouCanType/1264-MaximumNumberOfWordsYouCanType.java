// Last updated: 1/9/2026, 10:57:38 AM
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String arr[]= text.split(" ");
        int c=0;
        for(String s:arr){
            boolean can=true;
            for(int i=0; i< brokenLetters.length() ;i++){
                char ch =  brokenLetters.charAt(i);
                if(s.indexOf(ch) != -1){
                    // c++;
                    can = false;
                    break;
                }
            }
            if(can) c++;
        }
        return c;
    }
}