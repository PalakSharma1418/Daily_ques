// Last updated: 8/6/2025, 4:46:05 PM
class Solution {
    public int numDupDigitsAtMostN(int n) {
        List<Integer> digits = new ArrayList<>();
        int x = n + 1;  
        while (x > 0) {  
            digits.add(x % 10);  
            x /= 10;  
        }
        Collections.reverse(digits);
        int len = digits.size();

        //  unique digit number less than n
        int uniqueCount = 0;
        for (int i = 1; i < len; i++) {  
            uniqueCount += 9 * permutation(9, i - 1);
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int d = (i == 0 ? 1 : 0); d < digits.get(i); d++) {
                if (!seen.contains(d)) {
                    uniqueCount += permutation(9 - i, len - i - 1);
                }
            }
            if (seen.contains(digits.get(i))) {
                break;
            }
            seen.add(digits.get(i));
        }
    return n - uniqueCount;
    }
    // P(n, k) = n! / (n-k)!
    private int permutation(int n, int k) {
    int res = 1;
    for (int i = 0; i < k; i++) {
        res *= (n - i);
    }
    return res;}

}