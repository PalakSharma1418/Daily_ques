// Last updated: 8/6/2025, 4:48:18 PM
class Solution {
    public int firstUniqChar(String s) {
        int [] frequency= new int[26];
        for(int i=0;i<s.length();i++){
            int c= s.charAt(i) -'a';
            frequency[c]++;
            // frequency[c%97]+=1;
        }
        for(int i=0;i<s.length();i++){
            if(frequency[s.charAt(i) -'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}