// Last updated: 1/9/2026, 10:57:45 AM
class Solution {
    public int tribonacci(int n) {
        int a =0;
        int b= 1;
        int c= 1;
        if(n==0) return a;
        if(n==1 || n==2) return 1;
        for(int i=3;i<=n;i++){
            int sum=a+b+c;
            a=b;
            b=c;
            c=sum;
        }
        return c;
    }
}