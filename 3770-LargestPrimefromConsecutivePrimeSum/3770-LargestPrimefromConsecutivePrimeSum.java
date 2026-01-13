// Last updated: 1/13/2026, 1:43:50 PM
1class Solution {
2    public int largestPrime(int n) {
3        if(n<2){
4            return 0;
5        }
6        boolean[] isPrime = sieve(n);
7        int sum = 0;
8        int answer = 0;
9        for (int i = 2; i <= n; i++) {
10            if (isPrime[i]) {
11                sum += i;
12                if (sum > n) break;
13                if (isPrime[sum]) {
14                    answer = sum;
15                }
16            }
17        }
18
19        return answer;
20    }
21    public boolean[] sieve(int n ){
22        boolean [] arr = new boolean[n+1];
23        Arrays.fill(arr, true);
24        arr[0]= false;
25        arr[1] = false;
26        for(int i =2 ; i*i <= n ; i++){
27            if(arr[i]){ 
28                for(int j = i*i ; j<=n ;j+=i){
29                    arr[j]=false;
30                }
31            }
32        }
33        return arr;
34    }
35}