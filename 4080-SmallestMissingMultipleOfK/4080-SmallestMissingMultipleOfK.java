// Last updated: 10/26/2025, 6:45:32 PM
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