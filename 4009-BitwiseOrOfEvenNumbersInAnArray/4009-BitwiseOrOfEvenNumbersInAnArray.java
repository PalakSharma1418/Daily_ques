// Last updated: 9/25/2025, 4:43:33 PM
class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int a=0;
        for(int n: nums){
            if(n%2==0){
                a|=n;
            }
        }
        return a;
    }
}