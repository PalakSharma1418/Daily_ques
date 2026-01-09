// Last updated: 1/9/2026, 10:58:27 AM
class Solution {
    String max = "";

    public String largestTimeFromDigits(int[] arr) {
        boolean[] used = new boolean[4];
        backtrack(arr, used, "");
        return max.equals("") ? "" : max.substring(0,2) + ":" + max.substring(2);
    }

    private void backtrack(int[] arr, boolean[] used, String s) {
        if (s.length() == 4) {
            int hour= Integer.parseInt(s.substring(0, 2));
            int min = Integer.parseInt(s.substring(2));

            if (hour < 24 && min < 60) {
                if (max.equals("") || s.compareTo(max) > 0) {
                    max = s;
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(arr, used, s + arr[i]);
                used[i] = false;
            }
        }
    }
}
