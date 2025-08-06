// Last updated: 8/6/2025, 4:43:46 PM
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int st = 0;
        for (int space : spaces) {
            sb.append(s, st, space).append(" ");
            st = space;
        }
        sb.append(s.substring(st));
        return sb.toString();
    }
}
