// Last updated: 3/11/2026, 8:00:20 PM
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int min =Integer.MAX_VALUE;
        int best = -1;
        for(int i=0 ; i<capacity.length ; i++){
            if(capacity[i]>=itemSize && capacity[i]<min){
                min = capacity[i];
                best=i;
            }
        }
        return best;
    }
}