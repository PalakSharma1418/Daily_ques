// Last updated: 1/26/2026, 11:28:37 AM
1class Solution {
2        public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        List<List<Integer>> res = new ArrayList();
4        Arrays.sort(arr);
5        int min = Integer.MAX_VALUE;
6        for (int i = 0; i < arr.length - 1; i++) {
7            int diff = arr[i + 1] - arr[i];
8            if (diff < min) {
9                min = diff;
10                res.clear();
11                res.add(Arrays.asList(arr[i], arr[i + 1]));
12            } else if (diff == min) {
13                res.add(Arrays.asList(arr[i], arr[i + 1]));
14            }
15        }
16        return res;
17    }
18}