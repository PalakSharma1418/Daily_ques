// Last updated: 11/10/2025, 8:09:06 PM
class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ops = 0;

        for (int num : nums) {
            // jo nya aya bo chota h 
            while (!st.isEmpty() && st.peek() > num) {
                st.pop();
            }
            if (num > 0 && (st.isEmpty() || st.peek() < num)) {
                st.push(num);
                ops++;
            }
        }

        return ops;
    }
}
