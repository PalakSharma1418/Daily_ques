// Last updated: 12/19/2025, 8:10:14 PM
1class Solution {
2    public int findLHS(int[] nums) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        for (int num : nums) {
5            map.put(num, map.getOrDefault(num, 0) + 1);
6        }
7
8        int ans = 0;
9        for (int key : map.keySet()) {
10            if (map.containsKey(key + 1)) {
11                ans = Math.max(ans, map.get(key) + map.get(key + 1));
12            }
13        }
14
15        return ans;
16    }
17}
18