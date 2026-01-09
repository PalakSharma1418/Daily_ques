// Last updated: 1/9/2026, 10:56:27 AM
class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        String temp = word;

        while (sequence.contains(temp)) {
            k++;
            temp += word;
        }

        return k;
    }
}
