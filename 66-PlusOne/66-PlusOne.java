// Last updated: 1/1/2026, 11:05:39 AM
1class Solution {
2    public int[] plusOne(int[] digits) {
3        int n = digits.length;
4        int ans[] = new int[n+1];
5        int carry=0;
6        int num =0;
7        for(int i=n ; i>0 ; i--){
8            if(i==n){
9                num= digits[i-1]+1;
10            }else{
11                num=digits[i-1]+carry;
12            }
13            int val = num%10;
14            ans[i]  = val;
15            carry = num/10;
16        }
17        ans[0]=carry;
18        if(ans[0]==0){
19            int g[] = new int[n];
20            for(int i=0;i<n;i++){
21                g[i]=ans[i+1];
22            }
23            return g;
24        }
25
26        return ans;
27    }
28}