// Last updated: 2/18/2026, 11:35:38 AM
import java.util.*;

class Solution {

    // Equivalent of find_number_of_subarrays
    private long findNumberOfSubarrays(long l, long r, long k) {
        l = l - 1;
        r = Math.min(k, r);

        long c1 = r;

        long c2Elements = (l >= k - r) ? (k - r) : l;
        long c2 = r * c2Elements;

        long leftSubArrRemainElements =
                (l >= c2Elements) ? (l - c2Elements) : 0;

        long c3 = Math.max(
                ((r - 1) * r / 2)
                        - ((r - leftSubArrRemainElements - 1)
                        * (r - leftSubArrRemainElements) / 2),
                0
        );

        if (leftSubArrRemainElements >= r - 1) {
            c3 = (r - 1) * r / 2;
        }

        return c1 + c2 + c3;
    }

    // Equivalent of sum_of_subarray_mins_or_maxs_atmostK
    private long sumOfSubarrayMinsOrMaxsAtMostK(
            int[] arr, int k, boolean isMinSubarrSum) {

        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        int n = arr.length;

        for (int ind = 0; ind < n; ind++) {
            int num = arr[ind];

            while (!stack.isEmpty() &&
                    (isMinSubarrSum
                            ? arr[stack.peekLast()] > num
                            : arr[stack.peekLast()] < num)) {

                int poppedInd = stack.pollLast();
                int leftCertainInd =
                        stack.isEmpty() ? 0 : stack.peekLast() + 1;

                long leftSubArray = poppedInd + 1L - leftCertainInd;
                long rightSubArray = ind - poppedInd;

                ans += findNumberOfSubarrays(
                        leftSubArray, rightSubArray, k
                ) * arr[poppedInd];
            }
            stack.addLast(ind);
        }

        while (!stack.isEmpty()) {
            int poppedInd = stack.pollLast();
            int leftCertainInd =
                    stack.isEmpty() ? 0 : stack.peekLast() + 1;

            long leftSubArray = poppedInd + 1L - leftCertainInd;
            long rightSubArray = n - poppedInd;

            ans += findNumberOfSubarrays(
                    leftSubArray, rightSubArray, k
            ) * arr[poppedInd];
        }

        return ans;
    }

    // Main function
    public long minMaxSubarraySum(int[] arr, int k) {
        return sumOfSubarrayMinsOrMaxsAtMostK(arr, k, true)
             + sumOfSubarrayMinsOrMaxsAtMostK(arr, k, false);
    }
}
