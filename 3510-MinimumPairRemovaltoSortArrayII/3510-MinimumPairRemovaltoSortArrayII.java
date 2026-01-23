// Last updated: 1/23/2026, 7:49:00 PM
1class Solution {
2
3    static class Pair {
4        long sum;
5        int idx;
6
7        Pair(long sum, int idx) {
8            this.sum = sum;
9            this.idx = idx;
10        }
11
12        @Override
13        public boolean equals(Object o) {
14            if (this == o) return true;
15            if (!(o instanceof Pair)) return false;
16            Pair p = (Pair) o;
17            return sum == p.sum && idx == p.idx;
18        }
19
20        @Override
21        public int hashCode() {
22            return Objects.hash(sum, idx);
23        }
24    }
25
26    public int minimumPairRemoval(int[] nums) {
27        int n = nums.length;
28
29        // {a, b, c, d} -> {a, b+c, d}
30        long[] temp = new long[n];
31        for (int i = 0; i < n; i++) {
32            temp[i] = nums[i];
33        }
34
35        TreeSet<Pair> minPairSet = new TreeSet<>(
36            (a, b) -> {
37                if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
38                return Integer.compare(a.idx, b.idx);
39            }
40        );
41
42        int[] nextIndex = new int[n];
43        int[] prevIndex = new int[n];
44
45        for (int i = 0; i < n; i++) {
46            nextIndex[i] = i + 1;
47            prevIndex[i] = i - 1;
48        }
49
50        int badPairs = 0;
51        for (int i = 0; i < n - 1; i++) {
52            if (temp[i] > temp[i + 1]) {
53                badPairs++;
54            }
55            minPairSet.add(new Pair(temp[i] + temp[i + 1], i));
56        }
57
58        int operations = 0;
59
60        while (badPairs > 0) {
61
62            Pair cur = minPairSet.first();
63            minPairSet.remove(cur);
64
65            int first = cur.idx;
66            int second = nextIndex[first];
67
68            int first_left = prevIndex[first];
69            int second_right = nextIndex[second];
70
71            if (temp[first] > temp[second]) {
72                badPairs--;
73            }
74
75            // {d, (a, b)}
76            if (first_left >= 0) {
77                if (temp[first_left] > temp[first] &&
78                    temp[first_left] <= temp[first] + temp[second]) {
79                    badPairs--;
80                }
81                else if (temp[first_left] <= temp[first] &&
82                         temp[first_left] > temp[first] + temp[second]) {
83                    badPairs++;
84                }
85            }
86
87            // {(a, b), d}
88            if (second_right < n) {
89                if (temp[second_right] >= temp[second] &&
90                    temp[second_right] < temp[first] + temp[second]) {
91                    badPairs++;
92                }
93                else if (temp[second_right] < temp[second] &&
94                         temp[second_right] >= temp[first] + temp[second]) {
95                    badPairs--;
96                }
97            }
98
99            if (first_left >= 0) {
100                minPairSet.remove(
101                    new Pair(temp[first_left] + temp[first], first_left)
102                );
103                minPairSet.add(
104                    new Pair(temp[first_left] + temp[first] + temp[second], first_left)
105                );
106            }
107
108            if (second_right < n) {
109                minPairSet.remove(
110                    new Pair(temp[second] + temp[second_right], second)
111                );
112                minPairSet.add(
113                    new Pair(temp[first] + temp[second] + temp[second_right], first)
114                );
115                prevIndex[second_right] = first;
116            }
117
118            nextIndex[first] = second_right;
119            temp[first] += temp[second];
120
121            operations++;
122        }
123
124        return operations;
125    }
126}