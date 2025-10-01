// Last updated: 10/1/2025, 4:13:10 PM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=0;
        for(int i=0;i<accounts.length;i++){
            int s=0;
            for(int j=0;j<accounts[0].length;j++){
                s+=accounts[i][j];
            }
            ans=Math.max(ans,s);
        }
        return ans;
    }
}