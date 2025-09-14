// Last updated: 9/14/2025, 7:15:27 PM
class Solution {
    public int earliestTime(int[][] tasks) {
     int ans=Integer.MAX_VALUE;
        for(int[]a:tasks){
            ans=Math.min(ans,a[0]+a[1]);
        }
        return ans;
    }
}