// Last updated: 1/24/2026, 5:14:07 PM
1class Solution {
2    public int totalSteps(int[] nums) {
3        int step =0 ;
4        Stack<int[]> st = new Stack<>();
5        int re =0;
6        for(int n : nums){
7            step=0;
8            while(!st.isEmpty() && st.peek()[0] <= n){
9                step = Math.max(step , st.pop()[1]);
10            }
11            if(st.isEmpty()){
12                step =0;
13            }else{
14                step++;
15            }
16
17            re = Math.max(re,step);
18            st.push(new int[]{n,step});
19        }
20        return re;
21    }
22}