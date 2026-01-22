// Last updated: 1/22/2026, 8:31:40 PM
1class Solution {
2    public int maximizeWin(int[] prizePositions, int k) {
3        
4        int n = prizePositions.length;
5        int leftMax[] = new int[n];
6        int rightMax[] = new int[n];
7
8        leftMax[0] = 1;
9        for(int i = 1, j = 0; i < n; i++) {
10            while(prizePositions[i] - prizePositions[j] > k) {
11                j++;
12            }
13            leftMax[i] = Math.max(leftMax[i-1], i-j+1);
14        }
15
16        rightMax[n-1] = 1;
17        for(int i = n-2, j = n-1; i >= 0; i--) {
18            while(prizePositions[j] - prizePositions[i] > k) {
19                j--;
20            }
21            rightMax[i] = Math.max(rightMax[i+1], j-i+1);
22        }
23        
24        int res = 0 ;
25        for(int i = 0; i <= n; i++) {
26            res = Math.max(res, (i == 0 ? 0 : leftMax[i - 1]) + (i == n ? 0 : rightMax[i]));
27        }
28        return res;
29    }
30}