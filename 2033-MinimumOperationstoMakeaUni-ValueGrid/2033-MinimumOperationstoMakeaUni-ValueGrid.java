// Last updated: 4/28/2026, 12:07:57 PM
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        ArrayList<Integer> nums = new ArrayList<>();
4        int res=0;
5        for(int i=0;i<grid.length;i++){
6            for(int j=0;j<grid[0].length;j++){
7                nums.add(grid[i][j]);
8            }
9        }
10        Collections.sort(nums);
11        int len= nums.size();
12        int commonno= nums.get(len/2);
13        for(int num : nums){
14            if(num%x != commonno%x){
15                return -1;
16            }
17        
18        res += Math.abs(commonno - num)/x;}
19    
20    return res;}
21}