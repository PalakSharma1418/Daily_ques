// Last updated: 8/6/2025, 4:49:06 PM
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        combination(n, k ,ll, 1,ans);
        return ans;
    }
    public static void combination(int n,int k, List<Integer> ll,int idx,List<List<Integer>> ans){
        if(n==0 && k==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(n<0 && k<ll.size()){
            return;
        }
        for(int i=idx;i<=9;i++){
                ll.add(i);
                combination(n-i,k-1,ll,i+1,ans);
                ll.remove(ll.size()-1); 
            }
    }
}