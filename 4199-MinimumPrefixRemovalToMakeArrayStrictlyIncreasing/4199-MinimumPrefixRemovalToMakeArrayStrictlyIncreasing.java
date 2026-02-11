// Last updated: 2/11/2026, 7:19:50 AM
class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int[] prefix = new int [n];
        int i=n-1;
        while(i>0 && nums[i-1] < nums[i]){
            i--;
        }
        return i;
    }
}