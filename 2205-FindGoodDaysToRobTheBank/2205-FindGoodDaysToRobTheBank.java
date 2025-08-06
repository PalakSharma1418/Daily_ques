// Last updated: 8/6/2025, 4:43:52 PM
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();
        if (n < 2 * time + 1) return result;

        int[] nonInc = new int[n]; // Days before that are non-increasing
        int[] nonDec = new int[n]; // Days after that are non-decreasing

        // Fill non-increasing prefix counts--decreasing
        // If security[i] is less than or equal to the previous day, increase the count.
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                nonInc[i] = nonInc[i - 1] + 1;
            }
        }

        // Fill non-decreasing suffix counts--increasing.
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                nonDec[i] = nonDec[i + 1] + 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (nonInc[i] >= time && nonDec[i] >= time) {
                result.add(i);
            }
        }

        return result;
    }
}
