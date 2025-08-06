// Last updated: 8/6/2025, 4:41:04 PM
class Solution {
      public boolean checkEqualPartitions(int[] nums, long target) {
        int n =nums.length;
        long p =1;
        for(int i=0;i<n;i++){
            p = p * nums[i];
            if(nums[i] > target) return false;
        }
        return target * target == p ? true : false;
    }
}
// class Solution {
//     public boolean checkEqualPartitions(int[] nums, long target) {
//         return answer(nums,target,0,1,1,false,false);
//     }
//     public static boolean answer(int[] nums,long target,int idx,long prodA,long prodB,boolean hasA,boolean hasB){
//             if(idx==nums.length){
//                 return hasA && hasB && prodA == target && prodB ==target;
//             }
//             int val = nums[idx];
//             if(prodA*val <= target){
//                 if(answer(nums,target,idx+1,prodA*val,prodB,true,hasB)){
//                     return true;
//                 }
//             }
//             if(prodB *val <=target){
//                 if(answer(nums,target,idx+1,prodA,prodB*val,hasA,true)){
//                     return true;
//                 }
//             }
//             // return true;
//             return false;
//         }
// }














