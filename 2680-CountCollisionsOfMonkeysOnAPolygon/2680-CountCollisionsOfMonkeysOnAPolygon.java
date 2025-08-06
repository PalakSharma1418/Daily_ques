// Last updated: 8/6/2025, 4:42:31 PM
class Solution {
    public int monkeyMove(int n) {
        long mod = 1_000_000_007;
        long total = modPow(2, n, mod);
        total = (total - 2 + mod) % mod; // avoid negative
        return (int) total;
    }
    private long modPow(int n, long pow,long mod){
        if(pow==0) return 1;
        long ans=modPow(n,pow/2,mod);
        ans=(ans*ans)%mod;
        if(pow%2!=0) ans=(ans*n)%mod;
        return ans%mod;
    }
}