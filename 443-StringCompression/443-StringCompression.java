// Last updated: 8/6/2025, 4:47:55 PM
class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++; 
            } else {
                sb.append(chars[i - 1]); 
                if (count > 1) {
                    sb.append(count); }
                count = 1; 
            }
        }
        sb.append(chars[chars.length - 1]);
        if (count > 1) {
            sb.append(count);
        }
        for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }
        
        return sb.length(); 
    }
}
