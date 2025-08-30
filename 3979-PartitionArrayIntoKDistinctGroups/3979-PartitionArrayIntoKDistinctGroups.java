// Last updated: 8/30/2025, 8:13:52 PM
class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n= nums.length;
        if(n%k!=0) return false;

        Map<Integer,Integer> freq = new HashMap<>();
        for(int nu: nums){
            freq.put(nu,freq.getOrDefault(nu,0)+1);
        }

        int g= n/k;
            for(int no : freq.values()){
                if(no>g) return false;
            }
        return true;
    }
}