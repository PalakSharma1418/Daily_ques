// Last updated: 8/6/2025, 4:42:40 PM
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer>  ll = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            List<Integer> two = new ArrayList<>();
            while(n>0){
                two.add(n%10);
                n=n/10;
            }
            for(int j= two.size()-1;j>=0;j--){
                ll.add(two.get(j));
            }
        }
        int[] ans = new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            ans[i] = ll.get(i);
        }
        return ans;
        
    }
}