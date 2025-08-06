// Last updated: 8/6/2025, 4:43:18 PM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long sucess) {
        int n=spells.length;
        int m=potions.length;
        int re[]= new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int number=spells[i];
            int lo=0; 
            int hi=m-1;
            int q=m;
            while(lo<=hi){
                int mid=(lo+hi)/2;
                if((long)potions[mid]*number>=sucess){
                    q=mid;
                    hi=mid-1;
                }
                else {
                    lo=mid+1;
                }
            }
            re[i]=m-q;
        }
        return re;
    }
}