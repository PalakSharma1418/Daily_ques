// Last updated: 11/3/2025, 8:22:38 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), sum = 0;
        for (int i = 1; i < n; i++) {
            int maxi = 0;
            while (i < n && colors.charAt(i) == colors.charAt(i - 1)) {
                sum += neededTime[i - 1];
                maxi = Math.max(maxi, neededTime[i - 1]);
                i++;
            }
            // us same group ka last bala to rhega aa
            sum += neededTime[i - 1];
            maxi = Math.max(maxi, neededTime[i - 1]);
            if (maxi != 0) sum -= maxi;
        }
        return sum;
    }
}