// Last updated: 8/6/2025, 4:48:43 PM
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=1,high=n,ans=0;
        while(low<=high){
            // int mid=(low+high)/2;
            int mid=low+(high-low)/2;
            if(isBadVersion(mid)==true){
                ans=mid;
                high=mid-1;
            }
            
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}