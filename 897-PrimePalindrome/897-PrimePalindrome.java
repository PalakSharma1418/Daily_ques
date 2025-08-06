// Last updated: 8/6/2025, 4:46:47 PM
class Solution {
    public int primePalindrome(int n) {
        if(n <= 2) return 2;
        if( n <= 11){
            for(int i = n ; i <= 11 ; i++){
                if(isPrime(i)) return i;
            }
        }
        if(n%2==0) n++;
        while(true){
            String s = String.valueOf(n);
            int len = s.length();
            if(len%2==0){
                n= (int)Math.pow(10,len)+1;
                continue;
            }
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            n+=2;

        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}