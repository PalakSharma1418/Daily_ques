// Last updated: 10/7/2025, 7:01:29 AM
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1]; // 1-indexed
        backtrack(n, 1, used);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                backtrack(n, pos + 1, used);
                used[i] = false;
            }
        }
    }
}
