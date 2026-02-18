// Last updated: 2/18/2026, 11:35:32 AM
class Solution {
    public double separateSquares(int[][] squares) {
        double miny = Double.MAX_VALUE;
        double maxy = Double.MIN_VALUE;
        //int area = 0;
        for(int i=0 ; i < squares.length ; i++){
            int y= squares[i][1];
            int l= squares[i][2];
            miny = Math.min(miny , y);
            maxy = Math.max(maxy , y+l);
            //area+=l*l;
        }     
        double lo = miny;
        double hi = maxy;
        while(hi - lo > 1e-6)
        {
            double mid = (lo+hi)/2.0 ;
            if (areaDiff(squares, mid) > 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private double areaDiff(int[][] squares, double H) {
        double below = 0.0;
        double above = 0.0;

        for (int[] sq : squares) {
            double y = sq[1];
            double side = sq[2];
            double bottom = y;
            double top = y + side;

            if (H <= bottom) {
                above += side * side;
            } 
            else if (H >= top) {
                below += side * side;
            } 
            else {
                below += (H - bottom) * side;
                above += (top - H) * side;
            }
        }
        return above - below;
    }
}