// Last updated: 8/6/2025, 4:44:05 PM
class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1_000_000_007;
        long even = (n + 1) / 2; //0 indexing
        long odd = n / 2;
        
        long res = (modPow(5, even,mod) * modPow(4, odd,mod)) % mod;
        return (int) res;
    }
    private long modPow(int n, long pow,long mod){
        if(pow==0) return 1;
        long ans=modPow(n,pow/2,mod);
        ans=(ans*ans)%mod;
        if(pow%2!=0) ans=(ans*n)%mod;
        return ans%mod;
    }
}