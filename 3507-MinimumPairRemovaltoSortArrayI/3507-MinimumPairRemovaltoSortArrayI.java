// Last updated: 1/22/2026, 12:02:53 PM
1class Solution {
2
3    public int minimumPairRemoval(int[] nums) {
4        List<Integer> v = new ArrayList<>();
5        for(int x : nums) v.add(x);
6        int ops = 0;
7        while(!isSorted(v)){
8            int pos = minPair(v);
9            mergePair(v, pos);
10            ops++;
11        }
12        return ops;
13    }
14
15    
16    public int minPair(List<Integer> v) {
17        int minSum = (int)1e9;
18        int pos = -1;
19        for(int i = 0; i < v.size() - 1; i ++){
20            int sum = v.get(i) + v.get(i + 1);
21            if (sum < minSum) {
22                minSum = sum;
23                pos = i;
24            }
25        }
26        return pos;
27    }
28
29    public void mergePair(List<Integer> v, int pos) {
30        v.set(pos, v.get(pos) + v.get(pos + 1));
31        v.remove(pos + 1);
32    }
33
34    private boolean isSorted(List <Integer> v) {
35        for(int i = 0; i < v.size() - 1; i ++){
36            if(v.get(i) > v.get(i + 1)) return false;
37        }
38        return true;
39    }
40}