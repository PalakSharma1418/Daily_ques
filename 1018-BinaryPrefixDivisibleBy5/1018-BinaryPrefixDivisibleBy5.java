// Last updated: 11/24/2025, 7:22:47 PM
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int val = 0;
        for(int ele : nums){
            val = ((val*2)+ele)%5;
            ans.add(val==0);
        }
        return  ans;
    }
}