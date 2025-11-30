// Last updated: 11/30/2025, 6:58:19 PM
1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        int n = nums.length;
4        int sum = 0;
5
6        // Calculate the sum of all elements and take % p
7        for (int num : nums) {
8            sum = (sum + num) % p;
9        }
10
11        int target = sum % p;
12        
13        // If sum is already divisible by p, no need to remove any subarray
14        if (target == 0) {
15            return 0;
16        }
17
18        HashMap<Integer, Integer> map = new HashMap<>();
19        map.put(0, -1);  // Initialize with remainder 0 at index -1
20        
21        int curr = 0;
22        int result = n;
23        
24        // Traverse through the array
25        for (int j = 0; j < n; j++) {
26            curr = (curr + nums[j]) % p;
27
28            // Calculate the remainder needed to achieve the target
29            int remain = (curr - target + p) % p;
30            
31            // If the required remainder exists in the map, update the result
32            if (map.containsKey(remain)) {
33                result = Math.min(result, j - map.get(remain));
34            }
35            
36            // Store the current remainder with its index
37            map.put(curr, j);
38        }
39
40        return result == n ? -1 : result;
41    }
42}