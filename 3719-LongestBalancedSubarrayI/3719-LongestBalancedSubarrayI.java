// Last updated: 1/19/2026, 11:24:27 AM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int no = nums.length;
4        int ans=0;
5        for(int l=0;l<no;l++){
6            Map<Integer,Integer> even = new HashMap<>();
7            Map<Integer,Integer> odd = new HashMap<>();
8            for(int r=l;r<no;r++){
9                int n= nums[r];
10                if(n%2==0){
11                    even.put(n,even.getOrDefault(n,0)+1);
12                }else{
13                    odd.put(n,odd.getOrDefault(n,0)+1);
14                }
15                if(even.size()==odd.size()){
16                    ans=Math.max(ans,r-l+1);
17                }
18            }
19        }
20        return ans;
21    }
22}