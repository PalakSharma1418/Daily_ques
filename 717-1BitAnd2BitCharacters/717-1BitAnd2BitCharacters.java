// Last updated: 8/6/2025, 4:47:07 PM
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int i=0;
        while(i<n){
            if(i==n-1){
                if(bits[i]==0){
                    return true;
                }
            }
            if (bits[i]==0){
                i++;
            }
            else{
                i+=2;
            }
        }
        return false;
    }
}