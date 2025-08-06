// Last updated: 8/6/2025, 4:47:18 PM
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int res=1;
        int a=0;
        int f=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(f<pairs[i][0]){
                res++;
                f=pairs[i][1];
            }
        }
        return res;
    }
}
// there cannot be possible for multiple chain because a<b b<c c<d