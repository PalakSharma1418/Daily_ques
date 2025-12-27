// Last updated: 12/27/2025, 1:15:04 PM
class Solution {
    public String generateTag(String caption) {

        if (caption == null || caption.trim().isEmpty()) {
            return "#";
        }

        String[] arr = caption.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(arr[0].toLowerCase());
        for (int i = 1; i < arr.length; i++) {
            sb.append(capitalize(arr[i]));
        }
        if (sb.length() > 100) {
            return sb.substring(0, 100);
        }
        return sb.toString();
    }

    private String capitalize(String word) {
        if (word.length() == 0) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
