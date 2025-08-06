// Last updated: 8/6/2025, 4:45:37 PM
class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (abc(map)) {
                count += (n - right);
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            }
        }
        return count;
    }

    public boolean abc(HashMap<Character, Integer> map) {  // Fixed type
        return map.getOrDefault('a', 0) > 0 && 
               map.getOrDefault('b', 0) > 0 && 
               map.getOrDefault('c', 0) > 0;  // Fixed condition
    }
}
