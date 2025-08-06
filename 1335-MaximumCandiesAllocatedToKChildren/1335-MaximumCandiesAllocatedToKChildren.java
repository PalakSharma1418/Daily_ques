// Last updated: 8/6/2025, 4:45:45 PM
class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        for(int i=0;i<candies.length;i++){
            sum+=candies[i];
        }
        if(sum<k){
            return 0;
        }
        int maxCandiesInPile = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandiesInPile = Math.max(maxCandiesInPile, candies[i]);
        }
        // Arrays.sort(candies); because working on candided rather than array
        int n= candies.length;
        int l=1; int r=maxCandiesInPile;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(ispossible(candies,k,mid)){
                l=mid+1;
                ans=mid;
            }
            else{
                 r=mid-1;
            }
        }
        return ans;
    }
    private boolean ispossible(int [] candies, long k,int mid){
        if(mid==0) return false;
        long h=0;
        for (int candy : candies) {
            h+= candy/mid;
            if(h>=k) return true;
        }
        return false;
    }
}