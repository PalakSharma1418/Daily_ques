// Last updated: 1/9/2026, 10:58:23 AM
// class Solution {
//     public int minDeletionSize(String[] strs) {
//         int count = 0;
//         int rows = strs.length;
//         int cols = strs[0].length();
//         for (int j = 0; j < cols; j++) {
//             for (int i = 0; i < rows - 1; i++) {
//                 if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
//                     count++;     
//                     break;       
//                 }
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;
        int m = strs[0].length();
        int deletions = 0;

        boolean[] sorted = new boolean[n - 1];

        for (int j = 0; j < m; j++) {

            boolean badColumn = false;

            // Step 1: check if column breaks order
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    deletions++;
                    badColumn = true;
                    break;
                }
            }

            // Step 2: update sorted pairs if column is good
            if (!badColumn) {
                for (int i = 0; i < n - 1; i++) {
                    if (!sorted[i] && strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        sorted[i] = true;
                    }
                }
            }
        }
        return deletions;
    }
}
