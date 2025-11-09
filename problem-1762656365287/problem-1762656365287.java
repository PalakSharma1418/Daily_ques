// Last updated: 11/9/2025, 8:16:05 AM
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i] , x -> new ArrayList<>()).add(i);
        }

        for(List<Integer> pos : map.values()){
            if(pos.size()>=3){
                for(int i=0;i+2<pos.size();i++){
                    int a = pos.get(i);
                    int c =pos.get(i+2);
                    int d = 2*(c-a);
                    ans=Math.min(ans,d);
                }
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}