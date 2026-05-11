// Last updated: 5/11/2026, 7:25:24 PM
1class Solution {
2    public int[] separateDigits(int[] nums) {
3        List<Integer>  ll = new ArrayList<>();
4        for(int i=0;i<nums.length;i++){
5            int n = nums[i];
6            List<Integer> two = new ArrayList<>();
7            while(n>0){
8                two.add(n%10);
9                n=n/10;
10            }
11            for(int j= two.size()-1;j>=0;j--){
12                ll.add(two.get(j));
13            }
14        }
15        int[] ans = new int[ll.size()];
16        for(int i=0;i<ll.size();i++){
17            ans[i] = ll.get(i);
18        }
19        return ans;
20        
21    }
22}