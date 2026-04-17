// Last updated: 4/17/2026, 6:47:25 AM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int minDist = Integer.MAX_VALUE;
5
6        for (int j = 0; j < nums.length; j++) {
7            if (map.containsKey(nums[j])) {
8                int i = map.get(nums[j]);
9                minDist = Math.min(minDist, j - i);
10            }
11
12            int rev = reverse(nums[j]);
13            map.put(rev, j);
14        }
15
16        return minDist == Integer.MAX_VALUE ? -1 : minDist;
17    }
18
19    private int reverse(int x) {
20        int rev = 0;
21        while (x > 0) {
22            rev = rev * 10 + (x % 10);
23            x /= 10;
24        }
25        return rev;
26    }
27}