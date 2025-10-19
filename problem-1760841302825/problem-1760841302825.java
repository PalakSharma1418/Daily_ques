// Last updated: 10/19/2025, 8:05:02 AM
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set= new HashSet<>();
        for(int n:nums){
            if(n%k==0){
                set.add(n);
            }
        }
        int f=k;
        while(true){
            if(!set.contains(f)){
                return f;
            }
            f+=k;
        }
    }
}