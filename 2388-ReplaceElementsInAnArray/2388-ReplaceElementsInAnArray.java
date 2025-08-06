// Last updated: 8/6/2025, 4:43:22 PM
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int[] pos = new int[1000001];
        for (int i = 0; i < nums.length; i++){
            pos[nums[i]] = i;
        }
        for (int i = 0; i < operations.length; i++){
            int oldNum = operations[i][0];
            int newNum = operations[i][1];
            int index = pos[oldNum];
            nums[index] = newNum;
            pos[newNum] = index;
        }
        return nums;
    }
}
// class Solution {
//     public int[] arrayChange(int[] nums, int[][] operation) {
//         for(int i=0;i<operation.length;i++){
//             int in=isPresent(nums,operation[i][0]);
//             if(in>=0){
//                 nums[in]=operation[i][1];
//             }
//         }
//         return nums;
//     }
//     public static int isPresent(int[] arr, int target) {
//         for (int i=0;i<arr.length;i++) {
//             if (arr[i] == target) {
//                 return i;
//             }
//         }
//         return -1;
// }
// }