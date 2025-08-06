// Last updated: 8/6/2025, 4:48:17 PM
class Solution {
    public char findTheDifference(String s, String t) {
        for(char e:t.toCharArray()){
            if(!s.contains(String.valueOf(e))){
                return e;
            }
            s = s.replaceFirst(String.valueOf(e), "");
        }
        return ' ';
    }
}