// Last updated: 11/4/2025, 5:44:48 AM
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] can = new int[n];
        Arrays.fill(can, 1);

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                can[i] = can[i - 1] + 1;
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                can[i] = Math.max(can[i], can[i + 1] + 1);
            }
        }

        // Sum up candies
        int sum = 0;
        for (int c : can) {
            sum += c;
        }
        return sum;
    }
}
