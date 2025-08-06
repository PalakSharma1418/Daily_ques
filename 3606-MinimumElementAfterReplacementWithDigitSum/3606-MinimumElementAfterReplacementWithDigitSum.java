// Last updated: 8/6/2025, 4:41:40 PM
class Solution {
    public int minElement(int[] nums) {
        int min =100000;
        for(int num: nums){
            min=Math.min(sum(num), min);
        }
        return min;
    }
    public int sum(int num){
        int rem=0;
        while(num>0){
            rem+=num%10;
            num/=10;
        }
        return rem;
    }
}