// Last updated: 2/11/2026, 7:19:48 AM
class Solution {
    public int countMonobit(int n) {
        int c=0;
        if(n>=0) c++;
        int v =1;
        while(v<=n){
            c++;
            v=(v<<1)|1;
        }
        return c;
    }
}