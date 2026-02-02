// Last updated: 2/2/2026, 12:51:44 PM
1class Solution {
2    public int maximumLength(String s) {
3        int n = s.length();
4        int[][] matrix = new int[26][n + 1]; // Matrix to store counts for each character and length
5        char prevChar = s.charAt(0);
6        int length = 0;
7
8        // Populate the matrix
9        for (int i = 0; i < n; i++) {
10            char currChar = s.charAt(i);
11
12            if (currChar == prevChar) {
13                length += 1;
14                matrix[currChar - 'a'][length] += 1;
15            } else {
16                length = 1;
17                matrix[currChar - 'a'][length] += 1;
18                prevChar = currChar;
19            }
20        }
21
22        int result = 0;
23
24        // Calculate the result by checking cumulative sums in reverse order
25        for (int i = 0; i < 26; i++) {
26            int cumSum = 0;
27            for (int j = n; j >= 1; j--) {
28                cumSum += matrix[i][j];
29                if (cumSum >= 3) {
30                    result = Math.max(result, j);
31                    break;
32                }
33            }
34        }
35
36        return result == 0 ? -1 : result;
37    }
38}