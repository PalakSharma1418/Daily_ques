// Last updated: 12/23/2025, 12:22:01 PM
1class Solution {
2    public String arrangeWords(String text) {
3        String arr[] = text.split(" ");
4        Arrays.sort(arr , (a,b) -> a.length()-b.length());
5        StringBuilder sb = new StringBuilder();
6        sb.append(capitalize(arr[0]));
7        for (int i = 1; i < arr.length; i++) {
8            sb.append(" "+arr[i].toLowerCase());
9        }
10        return sb.toString();
11    }
12    private String capitalize(String word) {
13        if (word.length() == 0) return word;
14        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
15    }
16}