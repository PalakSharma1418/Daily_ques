// Last updated: 8/6/2025, 4:46:48 PM
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long sum = 0;
        for (int i = 0; i < shifts.length; i++) {
            sum += shifts[i];  
        }
        int n= s.length();
        char[] c=s.toCharArray();
        for(int i=0;i<n;i++){
            c[i]=(char)(((c[i]-'a'+sum)%26)+'a');
            sum-=shifts[i];
            }
        
        return new String(c);
    }
}