// Last updated: 2/22/2026, 7:43:24 PM
1class Solution {
2    public int binaryGap(int n) {
3        int maxdist = 0;
4        int currdist = 0;
5        boolean found = false;
6        
7        while (n > 0) {
8            int bit = n % 2;
9            
10            if (bit == 1) {
11                if (found) {
12                    maxdist = Math.max(maxdist, currdist);
13                }
14                currdist = 1;
15                found = true;
16            } else {
17                if (found) {
18                    currdist++;
19                }
20            }
21            
22            n /= 2;
23        }
24        
25        return maxdist;
26    }
27}