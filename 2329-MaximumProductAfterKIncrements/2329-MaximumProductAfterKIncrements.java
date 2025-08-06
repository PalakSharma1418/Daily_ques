// Last updated: 8/6/2025, 4:43:30 PM
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i); 
        }
        while(k-->0){
            int val = pq.poll();
            val++;
            pq.add(val);
        }
        long res = 1;
        int mod = 1000000007;
        while(!pq.isEmpty()){
            res = ((res%mod)*(pq.poll()%mod))%mod;
        }
        return (int)res;
    }
} 
// ye pq use kiya kyuki baar baar chota find karne mai tle aa rhi thi