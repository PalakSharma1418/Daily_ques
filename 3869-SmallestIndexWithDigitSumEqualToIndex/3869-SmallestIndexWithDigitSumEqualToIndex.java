// Last updated: 8/6/2025, 4:40:55 PM
class Solution {
    public int smallestIndex(int[] nums) {
        int in=-1;
        for(int i=0;i<nums.length;i++){
            int sum= sum(nums[i]);
            if(sum==i){
                return i;
            }
        }
        return in;
    }
    public static int sum(int n){
        int su=0;
        while(n>0){
            su= su+n%10;
            n=n/10;
        }
        return su;
    }
}