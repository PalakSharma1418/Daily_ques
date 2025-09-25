// Last updated: 9/25/2025, 4:43:31 PM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int n: nums){
            if(n<min) min=n;
            if(n>max) max=n;
        }
        return (long) k*(max-min);
    }
}