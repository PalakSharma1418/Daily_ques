// Last updated: 8/6/2025, 4:49:22 PM
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b)-> (a+b).compareTo(b+a));
        if(arr[n-1].equals("0")){
            return "0";
        }
        String a="";
        for(int i=n-1 ; i>=0 ; i--){
            a+=arr[i];
        }
        return a;
    }
}