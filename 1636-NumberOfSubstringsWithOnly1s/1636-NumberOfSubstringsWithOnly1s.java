// Last updated: 1/9/2026, 10:56:41 AM
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