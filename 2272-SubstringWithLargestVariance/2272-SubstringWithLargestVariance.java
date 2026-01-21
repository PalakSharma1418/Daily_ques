// Last updated: 1/21/2026, 7:44:50 PM
1class Solution {
2    public int largestVariance(String s) {
3        
4        int[] count = new int[26];
5        for(char ch : s.toCharArray()) {
6            count[ch - 'a']++;
7        }
8
9        int result = 0;
10
11        for(char first = 'a'; first <= 'z'; first++) {
12            for(char second = 'a'; second <= 'z'; second++) {
13
14                if(first == second || count[first - 'a'] == 0 || count[second - 'a'] == 0) {
15                    continue;
16                }
17
18                int firstCount = 0;
19                int secondCount = 0;
20                boolean pastLowFlag = false;
21
22                for(char ch : s.toCharArray()) {
23                    if(ch == first) firstCount++;
24                    if(ch == second) secondCount++;
25
26                    if(secondCount > 0) {
27                        result = Math.max(result, firstCount - secondCount);
28                    }
29                    else{
30                        if(pastLowFlag){
31                            result = Math.max(result, firstCount - 1);
32                        }
33                    }
34
35                    if(secondCount > firstCount) {
36                        firstCount = 0;
37                        secondCount = 0;
38                        pastLowFlag = true;
39                    }
40                }
41            }
42        }
43
44        return result;
45    }
46}