// Last updated: 8/6/2025, 4:43:15 PM
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;

        // Store row occurrences in HashMap
        for (int[] row : grid) {
            String key = Arrays.toString(row); // Convert row to string
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        // Check columns against stored rows
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j]; // Extract column j
            }
            String key = Arrays.toString(col); // Convert column to string
            count += rowMap.getOrDefault(key, 0); // Add frequency if exists in map
        }

        return count;
    }
}
