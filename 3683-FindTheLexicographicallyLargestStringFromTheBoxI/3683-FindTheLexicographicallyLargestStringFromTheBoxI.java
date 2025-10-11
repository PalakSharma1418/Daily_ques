// Last updated: 10/11/2025, 8:55:29 PM
class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length()-numFriends+1; // maximum kitne length ki string ho skti h jab hum usko numfriends mai baatein
        char maxchar='a';
        for(char ch : word.toCharArray()){
            if(ch>maxchar){
                maxchar=ch;
            }
        }
        String result ="";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==maxchar){
                if (i + n <= word.length()) {
                    String sub = word.substring(i, i + n);
                    if (sub.compareTo(result) > 0) result = sub;
                } else {
                    String sub = word.substring(i);
                    if (sub.compareTo(result) > 0) result = sub;
                }
            }
            
        }
        return result;
    }
}