// Last updated: 8/6/2025, 4:40:53 PM
class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
       if (possible(1,nums.clone(),k) || possible(-1,nums.clone(),k) ){
          return true;
      }
    return false;
    }
    public static boolean possible(int t, int [] arr, int k){
        int o=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=t){
                arr[i]*=-1;
                arr[i+1]*=-1;
                o++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=t) return false;
        }
        return k>=o;
    }
}