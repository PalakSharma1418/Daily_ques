// Last updated: 8/6/2025, 4:41:14 PM
class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) { 
        boolean [] ar = new boolean[fruits.length];
        int re=0;
        int i=0;
        while(i<fruits.length){
            int j=0;
            while(j<baskets.length){
                if(baskets[j]>= fruits[i] && ar[j]==false){
                    re++;
                    ar[j]=true;
                    break;
                }
                j++;
            }
            i++;
        }
        return fruits.length-re;
    }
}