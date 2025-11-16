// Last updated: 11/16/2025, 7:38:43 AM
class Solution {
    public int numSub(String s) {
         long mod = 1000000007;
        long ans = 0;
        long c = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                c++;
            } else {
                ans = (ans + c * (c + 1) / 2) % mod;
                c = 0;
            }
        }

        ans = (ans + c * (c + 1) / 2) % mod;  
        return (int) ans;
    }
}