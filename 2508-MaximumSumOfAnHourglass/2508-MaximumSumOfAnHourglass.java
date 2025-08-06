// Last updated: 8/6/2025, 4:42:59 PM
class Solution {
    public int maxSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                int sum = arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]
                    + arr[i][j]
                    + arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
}