// Last updated: 12/27/2025, 1:15:15 PM
class Solution {
    
        
     // lexicographic constructive counting
        // Total permutations =
//          (total characters)! / (c1! * c2! * ...)

    

    private static final long LIMIT = 1_000_000_000L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        char middle = 0;
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = (char) (i + 'a');
            }
            freq[i] /= 2;
            halfLen += freq[i];
        }

        long total = countPermutations(freq, halfLen);
        if (total < k) return "";

        StringBuilder firstHalf = new StringBuilder();
        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] == 0) continue;
                freq[c]--;
                long cnt = countPermutations(freq, halfLen - pos - 1);
                if (cnt < k) {//All permutations starting with this character come before our answer
                    k -= cnt;
                    freq[c]++;
                } 
                else {
                    firstHalf.append((char) (c + 'a'));
                    break;
                }
            }
        }
        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();
        return middle == 0
                ? firstHalf + secondHalf.toString()
                : firstHalf + String.valueOf(middle) + secondHalf;
    }
    private long countPermutations(int[] freq, int total) {
    long res = 1;
    int used = 0;

    for (int f : freq) {
        for (int i = 1; i <= f; i++) {
            res = res * (used + i) / i;
            if (res > LIMIT) return LIMIT;
        }
        used += f;
    }
    return res;
}


    // private long countPermutations(int[] freq, int total) {
    //     long result = factorial(total);
    //     for (int f : freq) {
    //         result /= factorial(f);
    //     }
    //     return Math.min(result, LIMIT);
    // }

    // private long factorial(int n) {
    //     long res = 1;
    //     for (int i = 1; i <= n; i++) {
    //         res = Math.min(res * i, LIMIT);
    //     }
    //     return res;
    // }
}

