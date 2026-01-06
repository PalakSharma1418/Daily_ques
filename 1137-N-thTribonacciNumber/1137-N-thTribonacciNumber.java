// Last updated: 1/6/2026, 10:49:11 AM
1class Solution {
2    public int tribonacci(int n) {
3        int a =0;
4        int b= 1;
5        int c= 1;
6        if(n==0) return a;
7        if(n==1 || n==2) return 1;
8        for(int i=3;i<=n;i++){
9            int sum=a+b+c;
10            a=b;
11            b=c;
12            c=sum;
13        }
14        return c;
15    }
16}