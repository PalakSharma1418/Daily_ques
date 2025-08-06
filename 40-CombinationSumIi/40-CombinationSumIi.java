// Last updated: 8/6/2025, 4:51:05 PM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        combination(candidates, target,ll, 0,ans);
        return ans;
    }
    public static void combination(int [] coin,int amount, List<Integer> ll,int idx,List<List<Integer>> ans){
        if(amount==0){
            // System.out.println(ll);
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=idx;i<coin.length;i++){
            if (i >idx && coin[i] == coin[i - 1]) continue;
            if(amount>=coin[i]){
                ll.add(coin[i]);
                combination(coin,amount-coin[i],ll,i+1,ans);
                ll.remove(ll.size()-1); 
            }
        }
    }
}