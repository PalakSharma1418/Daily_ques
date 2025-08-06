// Last updated: 8/6/2025, 4:46:18 PM
class Solution {
    public int[][] kClosest(int[][] points, int k) {
      int n = points.length;
        int[][] dis = new int[n][2];
        for(int i=0;i<n;i++){
            int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            dis[i][0] = i; //index;
            dis[i][1] = d; //distance
        }
        int[][] ans = new int[k][2];
        Arrays.sort(dis, Comparator.comparingInt(a -> a[1]));
        for(int i=0;i<k;i++){
            int idx = dis[i][0];
            ans[i][0] = points[idx][0];
            ans[i][1] = points[idx][1];
        }
        return ans;
    }
}