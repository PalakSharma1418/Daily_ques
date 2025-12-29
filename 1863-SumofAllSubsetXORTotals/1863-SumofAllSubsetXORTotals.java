// Last updated: 12/29/2025, 7:14:07 PM
1class Solution {
2    int res=0;
3    public void backtrack(int[] nums,int idx,ArrayList temp){
4        if(idx==nums.length){
5            int xor=0;
6            for(int i=0;i<temp.size();i++){
7                xor=xor^(int)temp.get(i);
8            }
9            res+=xor;
10            return;
11        }
12        temp.add(nums[idx]);
13        backtrack(nums,idx+1,temp);
14        temp.remove(temp.size()-1);
15        backtrack(nums,idx+1,temp);
16    }
17    public int subsetXORSum(int[] nums) {
18        ArrayList<Integer>temp=new ArrayList<>();
19        backtrack(nums,0,temp);
20        return res;
21    } 
22}