// Last updated: 8/6/2025, 4:42:14 PM
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] s1EvenFreq = new int[26];
        int[] s2EvenFreq = new int[26];
        for (int i = 0; i < n; i += 2) {
            s1EvenFreq[s1.charAt(i) - 'a']++;
            s2EvenFreq[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1EvenFreq[i] != s2EvenFreq[i]) return false;
        }

        int[] s1OddFreq = new int[26];
        int[] s2OddFreq = new int[26];
        for (int i = 1; i < n; i += 2) {
            s1OddFreq[s1.charAt(i) - 'a']++;
            s2OddFreq[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1OddFreq[i] != s2OddFreq[i]) return false;
        }

        return true;
    }
}