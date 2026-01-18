// Last updated: 1/18/2026, 5:31:27 PM
1class Solution {
2    public int minimumOperations(int[] nums) {
3
4        int totalEven = 0, totalOdd = 0;
5
6        HashMap<Integer, Integer> mapEven = new HashMap<>();
7        HashMap<Integer, Integer> mapOdd = new HashMap<>();
8
9    
10        for (int i = 0; i < nums.length; i++) {
11            if (i % 2 == 0) {
12                totalEven++;
13                mapEven.put(nums[i], mapEven.getOrDefault(nums[i], 0) + 1);
14            } else {
15                totalOdd++;
16                mapOdd.put(nums[i], mapOdd.getOrDefault(nums[i], 0) + 1);
17            }
18        }
19
20        int firstEven = 0, firstEvenCount = 0;
21        int secondEven = 0, secondEvenCount = 0;
22
23        for (int num : mapEven.keySet()) {
24            int count = mapEven.get(num);
25
26            if (count >= firstEvenCount) {
27                secondEvenCount = firstEvenCount;
28                secondEven = firstEven;
29                firstEvenCount = count;
30                firstEven = num;
31            } else if (count >= secondEvenCount) {
32                secondEvenCount = count;
33                secondEven = num;
34            }
35        }
36
37        int firstOdd = 0, firstOddCount = 0;
38        int secondOdd = 0, secondOddCount = 0;
39
40        for (int num : mapOdd.keySet()) {
41            int count = mapOdd.get(num);
42
43            if (count >= firstOddCount) {
44                secondOddCount = firstOddCount;
45                secondOdd = firstOdd;
46                firstOddCount = count;
47                firstOdd = num;
48            } else if (count >= secondOddCount) {
49                secondOddCount = count;
50                secondOdd = num;
51            }
52        }
53
54        int operationsEven = totalEven - firstEvenCount;
55        if (firstEven != firstOdd)
56            operationsEven += (totalOdd - firstOddCount);
57        else
58            operationsEven += (totalOdd - secondOddCount);
59
60        int operationsOdd = totalOdd - firstOddCount;
61        if (firstOdd != firstEven)
62            operationsOdd += (totalEven - firstEvenCount);
63        else
64            operationsOdd += (totalEven - secondEvenCount);
65
66        return Math.min(operationsEven, operationsOdd);
67    }
68}
69