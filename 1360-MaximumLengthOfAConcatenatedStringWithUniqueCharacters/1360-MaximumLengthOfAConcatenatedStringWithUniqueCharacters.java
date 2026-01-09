// Last updated: 1/9/2026, 10:57:27 AM
import java.util.*;

class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, "", new HashMap<>());
    }

    private int helper(List<String> arr, int idx, String st, Map<String, Integer> memo) {
        if (idx == arr.size()) {
            return st.length();
        }

        // Create a unique key for memoization
        String key = idx + "|" + sorted(st);
        if (memo.containsKey(key)) return memo.get(key);

        String s = arr.get(idx);
        int take = 0;

        // Choice 1: take current string if valid
        if (nocommon(s, st) && unique(s)) {
            take = helper(arr, idx + 1, st + s, memo);
        }

        // Choice 2: skip current string
        int skip = helper(arr, idx + 1, st, memo);

        int ans = Math.max(take, skip);
        memo.put(key, ans);
        return ans;
    }

    private boolean nocommon(String a, String b) {
        boolean[] seen = new boolean[26];
        for (char c : a.toCharArray()) seen[c - 'a'] = true;
        for (char c : b.toCharArray()) if (seen[c - 'a']) return false;
        return true;
    }

    private boolean unique(String s) {
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) return false;
            seen[c - 'a'] = true;
        }
        return true;
    }

    // Helper to sort string (so "ab" and "ba" count same in memo)
    private String sorted(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
