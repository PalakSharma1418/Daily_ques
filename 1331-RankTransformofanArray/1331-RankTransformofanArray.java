// Last updated: 7/12/2026, 2:34:54 PM
1import java.util.*;
2
3class Solution {
4    public int[] arrayRankTransform(int[] arr) {
5        int[] sortedarr = arr.clone();
6        Arrays.sort(sortedarr);
7        Map<Integer, Integer> ranks = new HashMap<>();
8        int rank = 1;
9        for (int x : sortedarr) {
10            if (!ranks.containsKey(x)) {
11                ranks.put(x, rank);
12                rank++;
13            }
14        }
15        for (int i = 0; i < arr.length; i++) {
16            arr[i] = ranks.get(arr[i]);
17        }
18        return arr;
19    }
20}