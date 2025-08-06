// Last updated: 8/6/2025, 4:42:33 PM
class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Arrays.sort(ranks);
         int minRank = ranks[0];
        int n= ranks.length;
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }
        long left=0;
        long right=(long)minRank*cars*cars;
        long ans=-1;
        while(left<=right){
            long mid= left+(right-left)/2;
            if(isitpossible(ranks,cars,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public static boolean isitpossible(int[] ranks,int cars,long time){
        long count=0;
        for(int i=0;i<ranks.length;i++){
            int s= ranks[i];
            count= count + (long)(Math.sqrt(time/s));
            if(count>=cars) return true;
         }
         return false;
    }
}
        // i use last rank beause  maximum time last rank take 
        // min would work same beacause we neend to minimise it
    