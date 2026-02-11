// Last updated: 2/11/2026, 7:20:10 AM
class Solution {
    public int largestPrime(int n) {
        if(n<2){
            return 0;
        }
        boolean[] isPrime = sieve(n);
        int sum = 0;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
                if (sum > n) break;
                if (isPrime[sum]) {
                    answer = sum;
                }
            }
        }

        return answer;
    }
    public boolean[] sieve(int n ){
        boolean [] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0]= false;
        arr[1] = false;
        for(int i =2 ; i*i <= n ; i++){
            if(arr[i]){ 
                for(int j = i*i ; j<=n ;j+=i){
                    arr[j]=false;
                }
            }
        }
        return arr;
    }
}