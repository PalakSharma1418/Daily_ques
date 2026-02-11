// Last updated: 2/11/2026, 7:20:01 AM
class Solution {
    public int centeredSubarrays(int[] nums) {
        int len = nums.length;
        int a=0;
        for(int i=0;i<len;i++){
            int sum=0;
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<len;j++){
                sum+=nums[j];
                set.add(nums[j]);
                if(set.contains(sum)){
                    a++;
                }
            }
        }
        return a;
    }
}