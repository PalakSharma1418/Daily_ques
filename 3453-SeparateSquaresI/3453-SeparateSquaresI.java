// Last updated: 1/13/2026, 1:01:32 PM
1class Solution {
2    public double separateSquares(int[][] squares) {
3        double miny = Double.MAX_VALUE;
4        double maxy = Double.MIN_VALUE;
5        //int area = 0;
6        for(int i=0 ; i < squares.length ; i++){
7            int y= squares[i][1];
8            int l= squares[i][2];
9            miny = Math.min(miny , y);
10            maxy = Math.max(maxy , y+l);
11            //area+=l*l;
12        }     
13        double lo = miny;
14        double hi = maxy;
15        while(hi - lo > 1e-6)
16        {
17            double mid = (lo+hi)/2.0 ;
18            if (areaDiff(squares, mid) > 0) {
19                lo = mid;
20            } else {
21                hi = mid;
22            }
23        }
24
25        return lo;
26    }
27
28    private double areaDiff(int[][] squares, double H) {
29        double below = 0.0;
30        double above = 0.0;
31
32        for (int[] sq : squares) {
33            double y = sq[1];
34            double side = sq[2];
35            double bottom = y;
36            double top = y + side;
37
38            if (H <= bottom) {
39                above += side * side;
40            } 
41            else if (H >= top) {
42                below += side * side;
43            } 
44            else {
45                below += (H - bottom) * side;
46                above += (top - H) * side;
47            }
48        }
49        return above - below;
50    }
51}