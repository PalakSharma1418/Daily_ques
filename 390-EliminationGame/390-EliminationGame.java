// Last updated: 8/6/2025, 4:48:15 PM
class Solution {
    public int lastRemaining(int n) {
        int head=1;
        int step=1;
        boolean left= true;//l->r
        while(n>1){
            // head change
            if(left || n%2==1){
                head=head+step;
            }
            // change direction
            left=!left;
            step*=2; // 2 ki power mai
            n=n/2;
        }
        return head;
    }
}