// Last updated: 1/9/2026, 10:57:35 AM
class Solution {
    static final int MOD = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int x : arr) sum += x;
        int n = arr.length;
        long kad1 = kad_max(arr);
        if(k==1) return (int) kad1 % MOD;
        int num[]= new int[n*2];
        for(int i=0;i<n;i++){
            num[i]=arr[i];
            num[i+n]=arr[i];
        }

        long kad2= kad_max(num);

        long ans;
        if (sum > 0) {

            // ismai esa hai ki jab bhi hum k array rkhte hai to na phle ka suffix or kth ka prefix hota hia baki bich ke pure contribute karte hai 
            ans = kad2 + (k - 2) * sum;
        } else {
            ans = kad2;
        }

        return (int)(ans % MOD);

        
    }
    public static long kad_max(int[]arr){
        long sum=0;
        long ans=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}