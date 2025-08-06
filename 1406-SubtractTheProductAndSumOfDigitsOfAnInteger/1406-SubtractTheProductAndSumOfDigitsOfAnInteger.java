// Last updated: 8/6/2025, 4:45:42 PM
class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int pro=1;
        while(n>0){
            int r= n%10;
            sum+=r;
            pro*=r;
            n=n/10;
        }
        return pro-sum;
    }
}