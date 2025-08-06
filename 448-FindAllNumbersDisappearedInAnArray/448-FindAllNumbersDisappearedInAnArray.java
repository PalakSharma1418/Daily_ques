// Last updated: 8/6/2025, 4:47:54 PM

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ll=new ArrayList<Integer>();
        boolean[] arr=new boolean[nums.length];
         for(int i=0;i< nums.length ;i++){
            int a=nums[i];
            arr[a-1]=true;
         }
         for(int j=0;j<arr.length;j++){
            if(arr[j]==false){
                ll.add(j+1);
            }
         }
         return ll;
    }
}