// Last updated: 10/19/2026, 12:02:26 PM
1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3        List<Integer> ll = new ArrayList<>();
4        Arrays.sort(nums);
5        for(int i=0 ; i<nums.length ; i++){
6            if(nums[i]== target){
7                ll.add(i);
8            }
9        }
10        return ll;
11    }
12}