// Last updated: 8/6/2025, 4:47:58 PM
// class Solution {
//     public int arrangeCoins(int n) {
//         int i = 0; 
//         while (n > 0 && n > i) {
//             i++; 
//             n = n - i;
//         }
//         return i; //no of completed rows
//     }
// }
class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        long ans = 0;
        while(start <= end){
            long mid = start + (end - start)/2;
            long sum = mid * (mid + 1)/2;
            if(sum == n){
                return (int)mid;
            }
            else if(sum > n){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return (int) end;
    }
}
