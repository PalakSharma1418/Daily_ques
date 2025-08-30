// Last updated: 8/30/2025, 8:13:59 PM
class Solution {
    public int minSensors(int n, int m, int k) {
        int block=(2*k+1);
        int row=(n+block-1)/block;
        int col=(m+block-1)/block;
        return row*col;
    }
}