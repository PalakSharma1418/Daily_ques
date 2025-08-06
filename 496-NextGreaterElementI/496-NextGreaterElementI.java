// Last updated: 8/6/2025, 4:47:46 PM
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[]= new  int[nums1.length];
        int i=0,j=0;
        for(i=0;i<nums1.length;i++){
            int el=nums1[i];
            for(j=0;j<nums2.length;j++){
                int el2=nums2[j];
                if(el==el2){
                    int flag=-1;
                        for(int k=j+1;k<nums2.length;k++){
                            if(nums2[k]>el2){
                                ans[i]=nums2[k];
                                flag=0;
                                break;
                            }
                        }
                        if (flag==-1){
                        ans[i]=-1;
                    }
                   
                }
            }
        }
        return ans;
    }
}