// Last updated: 8/6/2025, 4:46:32 PM
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int idx = st.pop();
                int right = i - idx;
                int left = st.isEmpty() ? idx + 1 : idx - st.peek();
                ans = (ans + (long) arr[idx] * left * right % mod) % mod;
            }
            st.push(i);
        }

        // Process remaining elements in stack
        while (!st.isEmpty()) {
            int idx = st.pop();
            int right = arr.length - idx;
            int left = st.isEmpty() ? idx + 1 : idx - st.peek();
            ans = (ans + (long) arr[idx] * left * right % mod) % mod;
        }

        return (int) ans;
    }
}