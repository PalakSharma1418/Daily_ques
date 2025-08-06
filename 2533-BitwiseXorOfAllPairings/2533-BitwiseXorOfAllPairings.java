// Last updated: 8/6/2025, 4:42:54 PM
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=0,xor2=0;
        for(int num : nums1){
            xor1=xor1^num;
        }
        for(int num : nums2){
            xor2=xor2^num;
        }
        return (nums1.length%2==0?0:xor2)^(nums2.length%2==0?0:xor1);
    }
}