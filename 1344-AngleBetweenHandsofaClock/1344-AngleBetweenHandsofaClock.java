// Last updated: 6/18/2026, 1:41:18 PM
1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double minuteAngle = 6.0 * minutes;
4        double hourAngle = 30.0 * (hour % 12) + 0.5 * minutes;
5        double diff = Math.abs(hourAngle - minuteAngle);
6
7        return Math.min(diff, 360.0 - diff);
8    }
9}