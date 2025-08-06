// Last updated: 8/6/2025, 4:51:48 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ch[]= new int[256];
        Arrays.fill(ch,0);
        int r=0,l=0;
        int n=s.length();
        int maxlen=0;
        while(l<=r && r<n){
            int i=s.charAt(r);
            ch[i]++;
            while (ch[i] > 1) {
                ch[s.charAt(l)]--;
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}