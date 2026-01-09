// Last updated: 1/9/2026, 10:52:34 AM
class Solution {

    int answer = Integer.MAX_VALUE;
    public int findMinimumTime(List<Integer> strength, int k)  {
        boolean[] used = new boolean[strength.size()];
        dfs(strength, used, 1, 0, k);
        return answer;
    }
    void dfs(List<Integer> strength, boolean[] used, int x, int time, int k) {
        if (allUsed(used)) {
            answer = Math.min(answer, time);
            return;
        }

        for (int i = 0; i < strength.size(); i++) {
            if (!used[i]) {
                int neededTime = (strength.get(i) + x - 1) / x; // ceil
                used[i] = true;
                dfs(strength, used, x + k, time + neededTime, k);
                used[i] = false; 
            }
        }
    }

    boolean allUsed(boolean[] used) {
        for (boolean b : used) {
            if (!b) return false;
        }
        return true;
    }
}
