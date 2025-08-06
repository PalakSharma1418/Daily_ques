// Last updated: 8/6/2025, 4:50:40 PM
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;
    }
}