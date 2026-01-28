// Last updated: 1/28/2026, 1:43:11 PM
1class Solution {
2    public int countTexts(String pressedKeys) {
3        int count = 0;
4        long ans = 1;
5        int i=0;
6        while(i<pressedKeys.length()){
7            count = 0;
8            char curr = pressedKeys.charAt(i);
9            while(i<pressedKeys.length() && pressedKeys.charAt(i)==curr){
10                count++;
11                i++;
12            }
13            if(curr=='7' || curr=='9') ans = ans*helper4(count)%1000000007;
14            else ans = ans*helper3(count)%1000000007;
15
16            
17        }
18        return (int)ans;
19    }
20
21    public long helper3(int n){
22        if(n<=2) return n;
23        if(n==3) return 4;
24        long[] dp = new long[n];
25        dp[0]=1;
26        dp[1]=2;
27        dp[2]=4;
28        for(int i=3; i<n; i++){
29            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
30        }
31        return dp[n-1];
32    }
33
34    public long helper4(int n){
35        if(n<=2) return n;
36        if(n==3) return 4;
37        if(n==4) return 8;
38        long[] dp = new long[n];
39        dp[0]=1;
40        dp[1]=2;
41        dp[2]=4;
42        dp[3]=8;
43        for(int i=4; i<n; i++){
44            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4])%1000000007;
45        }
46        return dp[n-1];
47    }
48}