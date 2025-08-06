// Last updated: 8/6/2025, 4:44:43 PM
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        int n=nums1.length;
        int m= nums2.length;
        for(int i=0;i<n;i++){
            int J_index=0;
            int low=i;
            int high=m-1;
            while(low<=high){
                int j= (low+high)/2;
                if(nums1[i]<=nums2[j]){
                    J_index=j;
                    low=j+1;
                }else{
                    high=j-1;
                }
            }
            max=Math.max(J_index-i,max);
        }
        return max;
    }
}