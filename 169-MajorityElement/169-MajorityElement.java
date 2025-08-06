// Last updated: 8/6/2025, 4:49:25 PM
class Solution {
    public int majorityElement(int[] nums) {
        return moorevoting(nums);
    }
    public static int moorevoting(int[] arr) {
        int e=arr[0];
        int v=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==e){
                v++;
            }
            else{
                v--;
                if(v==0){
                    e=arr[i];
                    v=1;
                }
            }
        }return e;
        
    }
}