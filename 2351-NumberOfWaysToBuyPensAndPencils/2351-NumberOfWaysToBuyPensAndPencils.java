// Last updated: 8/6/2025, 4:43:27 PM
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long count = 0;
        long curr = 0;
        for(int i = 0;i<=total/cost1;i++){
            curr = total-(cost1*i);
            count += curr/cost2 + 1;//0 to k pencils, which is (k + 1) total options.
        }
        return count;
    }
}