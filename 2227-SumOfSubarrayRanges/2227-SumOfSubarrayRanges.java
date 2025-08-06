// Last updated: 8/6/2025, 4:43:49 PM
// class Solution {
//     public long subArrayRanges(int[] nums) {
//         return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
//     }

//     public long sumSubarrayMins(int[] arr) {
//         Stack<Integer> st = new Stack<>();
//         long ans = 0;
//         for (int i = 0; i < arr.length; i++) {
//             while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
//                 int idx = st.pop();
//                 int right = i - idx;
//                 int left = st.isEmpty() ? idx + 1 : idx - st.peek();
//                 ans += (long) arr[idx] * left * right;
//             }
//             st.push(i);
//         }
//         while (!st.isEmpty()) {
//             int idx = st.pop();
//             int right = arr.length - idx;
//             int left = st.isEmpty() ? idx + 1 : idx - st.peek();
//             ans += (long) arr[idx] * left * right;
//         }
//         return ans;
//     }

//     public long sumSubarrayMaxs(int[] arr) {
//         Stack<Integer> st = new Stack<>();
//         long ans = 0;
//         for (int i = 0; i < arr.length; i++) {
//             while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
//                 int idx = st.pop();
//                 int right = i - idx;
//                 int left = st.isEmpty() ? idx + 1 : idx - st.peek();
//                 ans += (long) arr[idx] * left * right;
//             }
//             st.push(i);
//         }
//         while (!st.isEmpty()) {
//             int idx = st.pop();
//             int right = arr.length - idx;
//             int left = st.isEmpty() ? idx + 1 : idx - st.peek();
//             ans += (long) arr[idx] * left * right;
//         }
//         return ans;
//     }
// }
class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int j=i;j<n;j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans = ans + max - min;
            }
        }
        return ans;
    }
}