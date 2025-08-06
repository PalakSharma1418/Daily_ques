// Last updated: 8/6/2025, 4:50:24 PM
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        combination(n, k ,ll, 1,ans);
        return ans;
    }
    public static void combination(int n,int k, List<Integer> ll,int idx,List<List<Integer>> ans){
        if(0 == k){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=idx;i<=n;i++){
                ll.add(i);
                combination(n,k-1,ll,i+1,ans);
                ll.remove(ll.size()-1); 
            }
        
    }
}