// Last updated: 1/16/2026, 3:44:51 PM
1class Solution {
2    int mod = (int)1e9+7;
3    public int countHousePlacements(int n) {
4        
5        if(n == 1)
6            return 4;
7        if(n == 2)
8            return 9;
9        long a = 2;
10        long b = 3;
11        if(n==1)
12            return (int)(a%mod);
13        if(n==2)
14            return (int)(b%mod);
15        long c=0;
16        for(int i=3;i<=n;i++)
17        {
18            c = (a+b)%mod;
19            a=b%mod;
20            b=c%mod;
21        }
22        
23        return (int)((c*c)%mod);
24    }
25}