// Last updated: 1/29/2026, 7:40:28 PM
1class Solution {
2    public int tupleSameProduct(int[] nums) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4
5        for(int i = 0; i < nums.length; i++){
6            for(int j = i + 1; j < nums.length; j++){
7                int prod = nums[i] * nums[j];
8                map.put(prod, map.getOrDefault(prod, 0) + 1);
9            }
10        }
11
12        int ans = 0;
13        for(int k : map.values()){
14            if(k > 1){
15                ans += (k * (k - 1) / 2) * 8;
16            }
17        }
18        return ans;
19    }
20}