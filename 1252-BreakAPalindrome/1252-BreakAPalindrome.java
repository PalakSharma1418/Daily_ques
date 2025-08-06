// Last updated: 8/6/2025, 4:45:54 PM
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return ""; 
        }

        char[] arr = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[n - 1] = 'b';
        return new String(arr);
    }
}
