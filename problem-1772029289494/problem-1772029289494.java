// Last updated: 2/25/2026, 7:51:29 PM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
4        
5        Arrays.sort(temp, (a, b) -> {
6            int countA = Integer.bitCount(a);
7            int countB = Integer.bitCount(b);
8            
9            if (countA == countB) {
10                return a - b;
11            }
12            return countA - countB;
13        });
14        
15        for (int i = 0; i < arr.length; i++) {
16            arr[i] = temp[i];
17        }
18        
19        return arr;
20    }
21}