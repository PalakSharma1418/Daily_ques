// Last updated: 8/6/2025, 4:44:45 PM
class Solution {
    public int findTheWinner(int n, int k) {
        return find(n,k)+1;
        // +1 because ans is one indexed based
    }
    public int find(int n, int k){
        if(n==1)
            return 0;
        int x= find(n-1,k);
        int y=(x+k)%n;
        return y;
    }
}