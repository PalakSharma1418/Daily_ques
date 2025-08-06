// Last updated: 8/6/2025, 4:47:59 PM
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int k = p.length();
        int initial = 0;
        int finalIndex = k;
        if (s.length() < k) {
            return result;
        }

        while (finalIndex <= s.length()) {
            String sub = s.substring(initial, finalIndex); 
            if (isAnagram(sub, p)) {
                result.add(initial); 
            }
            initial++;
            finalIndex++;
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
