// Last updated: 9/14/2025, 7:15:31 PM
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        PriorityQueue<Integer> p  = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> set = new HashSet<>();
        for(int no: nums){
            set.add(no);
        }
        p.addAll(set);
        int len = Math.min(k,p.size());
        int[]ans= new int[len];
        for(int j=0;j<len;j++){
            ans[j]=p.poll();
        }
        return ans;
    }
}