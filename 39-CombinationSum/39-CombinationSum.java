// Last updated: 12/19/2025, 10:56:30 AM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        
4        List<List<Integer>> ans = new ArrayList<>();
5        List<Integer> ll= new ArrayList<>();
6        combination(candidates, target,ll, 0,ans);
7        return ans;
8    }
9    public static void combination(int [] coin,int amount, List<Integer> ll,int idx,List<List<Integer>> ans){
10        if(amount==0){
11            // System.out.println(ll);
12            ans.add(new ArrayList<>(ll));
13            return;
14        }
15        for(int i=idx;i<coin.length;i++){
16            if(amount>=coin[i]){
17                ll.add(coin[i]);
18                combination(coin,amount-coin[i],ll,i,ans);
19                ll.remove(ll.size()-1); 
20            }
21        }
22    }
23}