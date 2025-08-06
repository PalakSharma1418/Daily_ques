// Last updated: 8/6/2025, 4:50:09 PM
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Arrays.sort(nums);
        Sub(nums, 0,ll,ans);
        return ans;        
    }

    public static void Sub(int arr[],int ind,List<Integer> ll,List<List<Integer>> res){
        if(ind==arr.length){
            res.add(new ArrayList<>(ll));//this add copy
            return;
        }
        
        ll.add(arr[ind]);
        Sub(arr, ind+1,ll,res);
        ll.remove(ll.size()-1);
        while (ind + 1 < arr.length && arr[ind] == arr[ind + 1]) {
            ind++;
        }
        Sub(arr, ind+1,ll,res);
    }
}
