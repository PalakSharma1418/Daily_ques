// Last updated: 8/6/2025, 4:46:15 PM
class Solution {
    public int[] sortedSquares(int[] nums) {
        int list[]= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            list[i]=nums[i]*nums[i];
        }
        Arrays.sort(list);
        return list;
    }
}