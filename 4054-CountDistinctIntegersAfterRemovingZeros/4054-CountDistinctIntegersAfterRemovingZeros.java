// Last updated: 12/11/2025, 7:32:38 AM
class Solution {
    Long dp[][];
    public long countDistinct(long n) {
        String s = Long.toString(n);
        int d = s.length();
        dp = new  Long[d][2];
        long ans=0;
        long p=9;
        for(int len=1;len<d;len++){
            ans+=p;
            p*=9;
        }
        ans+=dfs(s,0,1);
        return ans;
    }

    public long dfs(String s , int pos , int tight){
        if(pos == s.length()) return 1;
        if(dp[pos][tight]!=null) return dp[pos][tight];
        long res =0;
        int l = (tight==1)?(s.charAt(pos)-'0'):9;
        for(int d=1;d<=9;d++){
            if(d>l) break;
            int n   = (tight==1 && d==l)?1:0;
            res+=dfs(s,pos+1,n);
        }
        return dp[pos][tight]=res;
    }
}