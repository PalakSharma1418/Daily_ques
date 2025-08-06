// Last updated: 8/6/2025, 4:46:27 PM
public class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int flips = 0, ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                flips++;
            }
            flips = Math.min(flips, ones);
        }

        return flips;
    }
}
// do solution kiye 