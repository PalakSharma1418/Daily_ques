// Last updated: 6/21/2026, 10:36:06 AM
1class Solution {
2     public int numSubmatrixSumTarget(int[][] matrix, int target) {
3        int rows = matrix.length; // m
4        int cols = matrix[0].length; // n
5
6        // First take the cumulative sum row-wise
7        for (int row = 0; row < rows; row++) {
8            for (int col = 1; col < cols; col++) {
9                matrix[row][col] += matrix[row][col - 1];
10            }
11        }
12
13        // Now, find the "No. of subarrays with sum k" in the downward direction
14        int result = 0;
15        for (int startCol = 0; startCol < cols; startCol++) {
16            for (int currCol = startCol; currCol < cols; currCol++) {
17                // We need to find all submatrices sum
18
19                // Now comes the concept of "No. of subarrays with sum k"
20                Map<Integer, Integer> map = new HashMap<>();
21                map.put(0, 1);
22                int sum = 0;
23
24                // Go downwards row-wise
25                for (int row = 0; row < rows; row++) {
26                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);
27
28                    if (map.containsKey(sum - target)) {
29                        result += map.get(sum - target);
30                    }
31
32                    map.put(sum, map.getOrDefault(sum, 0) + 1);
33                }
34            }
35        }
36
37        return result;
38    }
39}