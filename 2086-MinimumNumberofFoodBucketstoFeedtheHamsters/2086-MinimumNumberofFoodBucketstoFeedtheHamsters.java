// Last updated: 1/5/2026, 12:10:58 PM
1class Solution {
2    public int minimumBuckets(String hamsters) {
3        int n = hamsters.length();
4        int buckets = 0;
5        HashSet<Integer> set = new HashSet<>();
6
7        for (int i = 0; i < n; ) {
8
9            if (hamsters.charAt(i) == 'H') {
10                if ((i - 1 >= 0 && set.contains(i - 1)) ||
11                    (i + 1 < n && set.contains(i + 1))) {
12                    i++;
13                    continue;
14                }
15
16                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
17
18                        buckets++;
19                        set.add(i + 1);
20                    
21                    i = i + 2; 
22                }
23
24                else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.') {
25
26                        buckets++;
27                        set.add(i - 1);
28                    
29                    i = i + 1;
30                }
31
32                else {
33                    return -1;
34                }
35            }
36            else {
37                i++;
38            }
39        }
40        return buckets;
41    }
42}
43