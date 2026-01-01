// Last updated: 1/1/2026, 7:01:35 PM
1class Solution {
2    public int findCenter(int[][] edges) {
3        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
4            return edges[0][0];
5        } else {
6            return edges[0][1];
7        }
8    }
9}