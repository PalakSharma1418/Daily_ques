// Last updated: 1/9/2026, 10:56:20 AM
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);
        int ans=0;
        for(int i=0;i<boxTypes.length;i++){
            int h = Math.min(boxTypes[i][0],truckSize);
            ans=ans+h*boxTypes[i][1];
            truckSize-=h;
            if(truckSize==0) return ans;
        }
        return ans;
    }
}