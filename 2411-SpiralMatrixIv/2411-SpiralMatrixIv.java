// Last updated: 8/6/2025, 4:43:16 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.Arrays;

class Solution {
    public int[][] spiralMatrix(int rows, int columns, ListNode head) {
        int[][] matrix = new int[rows][columns];

        // Fill the matrix with -1 initially
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }

        int minRow = 0, maxRow = rows - 1;
        int minCol = 0, maxCol = columns - 1;

        while (head != null) {
            // Left to Right
            for (int col = minCol; col <= maxCol && head != null; col++) {
                matrix[minRow][col] = head.val;
                head = head.next;
            }
            minRow++;

            // Top to Bottom
            for (int row = minRow; row <= maxRow && head != null; row++) {
                matrix[row][maxCol] = head.val;
                head = head.next;
            }
            maxCol--;

            // Right to Left
            for (int col = maxCol; col >= minCol && head != null; col--) {
                matrix[maxRow][col] = head.val;
                head = head.next;
            }
            maxRow--;

            // Bottom to Top
            for (int row = maxRow; row >= minRow && head != null; row--) {
                matrix[row][minCol] = head.val;
                head = head.next;
            }
            minCol++;
        }

        return matrix;
    }
}
