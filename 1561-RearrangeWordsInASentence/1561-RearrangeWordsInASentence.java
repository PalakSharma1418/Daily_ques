// Last updated: 1/9/2026, 10:57:03 AM
class Solution {
    public String arrangeWords(String text) {
        String arr[] = text.split(" ");
        Arrays.sort(arr , (a,b) -> a.length()-b.length());
        StringBuilder sb = new StringBuilder();
        sb.append(capitalize(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            sb.append(" "+arr[i].toLowerCase());
        }
        return sb.toString();
    }
    private String capitalize(String word) {
        if (word.length() == 0) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}