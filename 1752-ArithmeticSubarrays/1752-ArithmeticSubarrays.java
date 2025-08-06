// Last updated: 8/6/2025, 4:45:10 PM
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans= new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int arr[]= new int[r[i]-l[i]+1];
            int ind=0;
            for(int j=l[i] ;j<=r[i];j++){
                arr[ind++]= nums[j];
            }
            if(check(arr)){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
    public boolean check(int []arr){
        if(arr.length<2) return false;
        Arrays.sort(arr);
        int d= arr[1]-arr[0];
        for(int i=1;i<arr.length-1; i++){
            if((arr[i+1]-arr[i])!=d){
                return  false;
            }
        }
        return true;
    }
}