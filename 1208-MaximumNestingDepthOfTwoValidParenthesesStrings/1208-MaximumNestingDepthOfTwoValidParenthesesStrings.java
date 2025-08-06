// Last updated: 8/6/2025, 4:45:57 PM
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length () ,s1 =0;//depth a 
        int s2 = 0;//depth b
        int[] ans = new int [n] ;//a=0,b=1
        for ( int i = 0 ; i < n ; i ++ ){
            if ( seq.charAt (i) =='(' ){
                if ( s1 <= s2){
                    s1 ++;
                    ans[i] = 0;
                }
                else {
                    s2 ++;
                    ans [i] = 1 ;
                }
            }
            else {
                if ( s1 > s2){
                    s1 -- ;
                    ans [i] = 0 ;
                }
                else {
                    s2 --;
                    ans [i] = 1 ;
                }
            }
        }
        return ans ;
    }
}
