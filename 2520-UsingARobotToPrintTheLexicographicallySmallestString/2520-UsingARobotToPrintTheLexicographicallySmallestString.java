// Last updated: 8/6/2025, 4:42:57 PM
class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuf = new char[n];
        minSuf[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            minSuf[i] = (char) Math.min(s.charAt(i), minSuf[i + 1]);
        }

        Stack<Character> t = new Stack<>();
        StringBuilder p = new StringBuilder();

        for (int i = 0; i < n; i++) {
            t.push(s.charAt(i));

            while (!t.isEmpty() && (i == n - 1 || t.peek() <= minSuf[i + 1])) {
                p.append(t.pop());
            }
        }

        while (!t.isEmpty()) {
            p.append(t.pop());
        }

        return p.toString();
    }
}
