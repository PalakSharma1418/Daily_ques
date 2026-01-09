// Last updated: 1/9/2026, 10:57:07 AM
class Solution {
    public int numOfWays(int n) {
        long mod = 1000000007;
        
        long dpA = 6; // ABA
        long dpB = 6; // ABC
        
        for(int i = 2; i <= n; i++){
            long newA = (dpA * 3 + dpB * 2) % mod;
            long newB = (dpA * 2 + dpB * 2) % mod;
            
            dpA = newA;
            dpB = newB;
        }
        
        return (int)((dpA + dpB) % mod);
    }
}