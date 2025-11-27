// Last updated: 11/27/2025, 12:34:27 PM
1class Solution {
2    public int[] countBits(int n) {
3        int[] a= new int[n+1];
4        for(int i=1;i<=n;i++){
5            a[i]= CountSetBit1(i);
6        }
7        return a;
8    }
9    public static int CountSetBit1(int n ){ //tc log(n)
10        int ans=0;
11        while(n>0){
12            n=n&(n-1);
13            ans++;
14        }
15        return ans;
16    }
17}