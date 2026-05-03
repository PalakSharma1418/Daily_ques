// Last updated: 5/3/2026, 7:59:21 PM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        return s.length() == goal.length() && (s + s).contains(goal);
4    }
5}