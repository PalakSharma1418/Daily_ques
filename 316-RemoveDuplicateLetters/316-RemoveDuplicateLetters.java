// Last updated: 7/23/2026, 5:24:14 PM
1class Solution {
2    public String removeDuplicateLetters(String s) {
3
4        int[] freq = new int[26];
5        boolean[] visited = new boolean[26];
6        Stack<Character> st = new Stack<>();
7
8        // Count frequency of each character
9        for (char ch : s.toCharArray()) {
10            freq[ch - 'a']++;
11        }
12
13        // Traverse the string
14        for (char ch : s.toCharArray()) {
15
16            // Current character is being processed
17            freq[ch - 'a']--;
18
19            // If already present in stack, skip it
20            if (visited[ch - 'a']) {
21                continue;
22            }
23
24            // Remove larger characters if they appear again later
25            while (!st.isEmpty()
26                    && st.peek() > ch
27                    && freq[st.peek() - 'a'] > 0) {
28
29                visited[st.pop() - 'a'] = false;
30            }
31
32            st.push(ch);
33            visited[ch - 'a'] = true;
34        }
35
36        // Build answer
37        StringBuilder sb = new StringBuilder();
38
39        for (char ch : st) {
40            sb.append(ch);
41        }
42
43        return sb.toString();
44    }
45}