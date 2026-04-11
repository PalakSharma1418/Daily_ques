// Last updated: 4/11/2026, 5:26:03 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        Map<Integer, List<Integer>> map = new HashMap<>();
4        int ans=Integer.MAX_VALUE;
5        for(int i=0;i<nums.length;i++){
6            map.computeIfAbsent(nums[i] , x -> new ArrayList<>()).add(i);
7        }
8
9        for(List<Integer> pos : map.values()){
10            if(pos.size()>=3){
11                for(int i=0;i+2<pos.size();i++){
12                    int a = pos.get(i);
13                    int c =pos.get(i+2);
14                    int d = 2*(c-a);
15                    ans=Math.min(ans,d);
16                }
17            }
18        }
19
20        return ans==Integer.MAX_VALUE?-1:ans;
21        
22    }
23}