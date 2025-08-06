// Last updated: 8/6/2025, 4:48:12 PM
class Solution {
    public int integerReplacement(int n) {
        return replace((long)n);
    }
    
    public int replace(long n)
    {
       int ans=0;
        if(n<=1) return 0; 
        if(n%2==0)  ans=1+replace(n/2);
        else ans=1+Math.min(replace(n+1),replace(n-1));
        return ans;
    }
}