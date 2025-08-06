// Last updated: 8/6/2025, 4:51:08 PM
class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String st = "1"; // Start with "1"
        for (int i = 1; i < n; i++) {
            st = count(st);
        }
        return st;
    }
    public static String count(String s){
        StringBuilder c = new StringBuilder(); 
        int co = 1; 
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                co++;
            } else {
                c.append(co).append(s.charAt(i));
                co = 1; 
            }
        }

        return c.toString();
    }
}