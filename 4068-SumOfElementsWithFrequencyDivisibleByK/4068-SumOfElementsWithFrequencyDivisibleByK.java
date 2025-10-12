// Last updated: 10/12/2025, 11:44:59 AM
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int a=0;
        for(int h : map.keySet()){
            int v=map.get(h);
            if(v%k==0){
                a+=v*h;
            }
        }
        return a;
    }
}