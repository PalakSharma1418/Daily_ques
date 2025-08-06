// Last updated: 8/6/2025, 4:44:58 PM
class Solution {
    public int[] decode(int[] encoded, int first) {
        int n= encoded.length;
        int output[]= new int[n+1];
        output[0]=first;
        for(int i=0;i<n;i++){
//            A[i] = res[i] ^ res[i+1]
//          res[i+1] = res[i] ^ A[i]
            output[i+1]=output[i]^encoded[i];
        }
        return output;
    }
}