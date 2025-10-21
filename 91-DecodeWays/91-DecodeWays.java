// Last updated: 10/21/2025, 7:30:43 PM
class Solution {
    char[] ch = {'0','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int dp[]= new int[s.length()];
        Arrays.fill(dp,-1);
        return fun(s,0,dp);
    }
    public int fun(String s , int ind,int[]dp){
        if(ind==s.length()) {
            return 1;
        }
        if(ind>s.length()) {
            return 0;
        }

        if(dp[ind]!=-1) return dp[ind];

        int ans=0;
        // ek lenge
        String sub=s.substring(ind,ind+1);
        if(sub.equals("0")) return 0;
        ans+=fun(s,ind+1,dp);


        // do lenge
        if(ind + 1 < s.length()){       
            sub=s.substring(ind,ind+2);
            // if(sub>"26") return;
            // if(Integer.parseInt(sub) >26)  return 0; ye ek dum se result zero kar dega jab upar se agr answer aya bo value nhi rhegi
            if(Integer.parseInt(sub) >= 10 && Integer.parseInt(sub) <= 26) {
                ans += fun(s, ind + 2, dp);
            }
        }

        return dp[ind]=ans;
    }
}