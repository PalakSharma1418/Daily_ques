// Last updated: 8/6/2025, 4:51:46 PM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int indele1=-1,indele2=-1;
        int t=n+m;
        int ind2=t/2,ind1=ind2-1;
        int cnt=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                if(cnt==ind1) indele1=nums1[i];
                if(cnt==ind2) indele2=nums1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1) indele1=nums2[j];
                if(cnt==ind2) indele2=nums2[j];
                cnt++;
                j++;
            }
            if(indele1 !=-1 && indele2 != -1){
                break;
            }
        }
        while(i<n){
            if(cnt==ind1) indele1=nums1[i];
             if(cnt==ind2) indele2=nums1[i];
             cnt++;
             i++;
             if(indele1 !=-1 && indele2 != -1){
                break;
            }
        }
        while(j<m){
            if(cnt==ind1) indele1=nums2[j];
            if(cnt==ind2) indele2=nums2[j];
            cnt++;
            j++;
            if(indele1 !=-1 && indele2 != -1){
                break;
            }
        }
        if(t%2==1){
            return indele2;
        }
        return (double)((double)(indele1+indele2)/2.0);
    }
}