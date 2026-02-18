// Last updated: 2/18/2026, 11:35:33 AM
// class Solution {
//     public int maxFrequency(int[] nums, int k) {
//         int n = nums.length;

//         int alreadyK = 0;
//         for (int num : nums) {
//             if (num == k) alreadyK++;
//         }

//         int[] diff = new int[n];
//         for (int i = 0; i < n; i++) {
//             diff[i] = k - nums[i];
//         }

//         HashMap<Integer, Integer> map = new HashMap<>();
//         int maxLen = 0;

//         for (int i = 0; i < n; i++) {
//             if (diff[i] == 0) {
//                 map.clear();   // subarray break
//                 continue;
//             }

//             map.put(diff[i], map.getOrDefault(diff[i], 0) + 1);
//             maxLen = Math.max(maxLen, map.get(diff[i]));
//         }

//         return alreadyK + maxLen;
//     }
// }
class Solution {
    public int  maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int alreadyK = 0;

        for (int num : nums) {
            if (num == k) alreadyK++;
        }

        int answer = alreadyK;

        // nums[i] ∈ [1..50], k ∈ [1..50]
        for (int x = -50; x <= 50; x++) {
            if (x == 0) continue;

            int curr = 0, best = 0;

            for (int num : nums) {
                if (k - num == x) {
                    curr += 1;
                } else if (num == k) {
                    curr -= 1;
                }

                if (curr < 0) curr = 0;
                best = Math.max(best, curr);
            }

            answer = Math.max(answer, alreadyK + best);
        }

        return answer;
    }
}
