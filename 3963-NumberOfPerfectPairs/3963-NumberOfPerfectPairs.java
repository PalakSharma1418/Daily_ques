// Last updated: 8/30/2025, 8:13:55 PM
class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] abs= new long[n];
        for(int i=0;i<n;i++){
            abs[i]= Math.abs((long)nums[i]);
        }
        Arrays.sort(abs);
        long c=0;
        int r=0;
        for(int l=0;l<n;l++){
            if(r<=l) r=l+1;
            while(r<n && abs[r]<=2*abs[l]){
                r++;
            }
            c+=(r-l-1);
        }
        return c;
    }
}