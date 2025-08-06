// Last updated: 8/6/2025, 4:48:04 PM
class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        int[] num = new int[10];
        num[0] = count['z' - 'a']; // "zero"
        num[2] = count['w' - 'a']; // "two"
        num[4] = count['u' - 'a']; // "four"
        num[6] = count['x' - 'a']; // "six"
        num[8] = count['g' - 'a']; 
        num[3] = count['h' - 'a'] - num[8];
        num[5] = count['f' - 'a'] - num[4]; 
        num[7] = count['s' - 'a'] - num[6]; 
        num[1] = count['o' - 'a'] - num[0] - num[2] - num[4];
        num[9] = count['i' - 'a'] - num[5] - num[6] - num[8]; 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            while(num[i]-- > 0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}