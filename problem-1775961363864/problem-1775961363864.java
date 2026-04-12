// Last updated: 4/12/2026, 8:06:03 AM
1class Solution {
2    public double[] internalAngles(int[] sides) {
3        double a = sides[0];
4        double b = sides[1];
5        double c = sides[2];
6        if(a+b<= c || b+c<=a || a+c<=b){
7            return new double[0];
8        }
9        double aa = Math.toDegrees(Math.acos((b*b + c*c -a*a) / (2*b*c)));
10        double ab = Math.toDegrees(Math.acos((a*a + c*c -b*b) / (2*a*c)));
11        double ac = Math.toDegrees(Math.acos((b*b + a*a -c*c) / (2*b*a)));
12        double[]ans = {aa , ab ,ac};
13        Arrays.sort(ans);
14        return ans;
15    }
16}