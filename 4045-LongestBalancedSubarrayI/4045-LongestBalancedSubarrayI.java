// Last updated: 10/26/2025, 6:45:34 PM
class Solution {
    public int longestBalanced(int[] nums) {
        int no = nums.length;
        int ans=0;
        for(int l=0;l<no;l++){
            Map<Integer,Integer> even = new HashMap<>();
            Map<Integer,Integer> odd = new HashMap<>();
            for(int r=l;r<no;r++){
                int n= nums[r];
                if(n%2==0){
                    even.put(n,even.getOrDefault(n,0)+1);
                }else{
                    odd.put(n,odd.getOrDefault(n,0)+1);
                }
                if(even.size()==odd.size()){
                    ans=Math.max(ans,r-l+1);
                }
            }
        }
        return ans;
    }
}