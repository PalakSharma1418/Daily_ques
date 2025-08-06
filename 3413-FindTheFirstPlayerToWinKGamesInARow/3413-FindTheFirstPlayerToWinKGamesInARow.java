// Last updated: 8/6/2025, 4:41:56 PM
class Solution {
    public int findWinningPlayer(int[] arr, int k) {
        if (k > arr.length) {
            int m = arr[0];
            int in = 0;
            for (int i = 1; i < arr.length; i++) {
                if (m < arr[i]) {
                    m = arr[i];
                    in = i;
                }
            }
            return in;
        }

        if (k == 1) {
            return arr[0] > arr[1] ? 0 : 1;
        }

        int current_winner = arr[0];
        int ind = 0;
        int consecutive_wins = 0;
        for (int i = 1; i < arr.length; i++) {
            if (current_winner > arr[i]) {
                consecutive_wins++;
            } else {
                current_winner = arr[i];
                ind = i;
                consecutive_wins = 1;
            }
            if (consecutive_wins == k) {
                return ind;
            }
        }
        return ind;
    }
}
