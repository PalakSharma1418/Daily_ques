// Last updated: 1/9/2026, 10:58:21 AM
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int u : nums){
            if(set.contains(u)){
                return u;
            }
            set.add(u);
        }
        return -1;
    }
}