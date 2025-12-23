// Last updated: 12/23/2025, 12:06:52 PM
1class Solution {
2    public String generateTag(String caption) {
3
4        if (caption == null || caption.trim().isEmpty()) {
5            return "#";
6        }
7
8        String[] arr = caption.trim().split(" ");
9        StringBuilder sb = new StringBuilder();
10        sb.append("#");
11        sb.append(arr[0].toLowerCase());
12        for (int i = 1; i < arr.length; i++) {
13            sb.append(capitalize(arr[i]));
14        }
15        if (sb.length() > 100) {
16            return sb.substring(0, 100);
17        }
18        return sb.toString();
19    }
20
21    private String capitalize(String word) {
22        if (word.length() == 0) return word;
23        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
24    }
25}
26