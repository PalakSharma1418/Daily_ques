// Last updated: 6/14/2026, 7:42:36 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public int pairSum(ListNode head) {
13        // Step 1: Find middle of the list
14        ListNode slow = head, fast = head;
15        while (fast != null && fast.next != null) {
16            slow = slow.next;
17            fast = fast.next.next;
18        }
19
20        // Step 2: Reverse second half
21        ListNode secondHalf = reverse(slow);
22
23        // Step 3: Calculate twin sums
24        int maxSum = 0;
25        ListNode firstHalf = head;
26        while (secondHalf != null) {
27            int twinSum = firstHalf.val + secondHalf.val;
28            maxSum = Math.max(maxSum, twinSum);
29            firstHalf = firstHalf.next;
30            secondHalf = secondHalf.next;
31        }
32
33        return maxSum;
34    }
35
36    // Helper to reverse a linked list
37    private ListNode reverse(ListNode head) {
38        ListNode prev = null;
39        while (head != null) {
40            ListNode nextNode = head.next;
41            head.next = prev;
42            prev = head;
43            head = nextNode;
44        }
45        return prev;
46    }
47}
48