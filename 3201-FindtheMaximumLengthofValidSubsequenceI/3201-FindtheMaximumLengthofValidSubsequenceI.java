// Last updated: 1/10/2026, 7:00:26 PM
1class Solution {
2    public int maximumLength(int[] nums) {
3        int evenCount = 0, oddCount = 0;
4        int altEven = 0, altOdd = 0;
5        for (int num : nums){
6            int p = num % 2;  
7            if (p == 0) { 
8                evenCount++;           // Count for same-parity subsequence
9                altEven = altOdd + 1;  // Extend alternating sequence ending in odd
10            } 
11            else{ 
12                oddCount++;           // Count for same-parity subsequence
13                altOdd = altEven + 1; // Extend alternating sequence ending in even
14            }
15        }
16
17        return Math.max(Math.max(evenCount, oddCount), Math.max(altEven, altOdd));
18    }
19}