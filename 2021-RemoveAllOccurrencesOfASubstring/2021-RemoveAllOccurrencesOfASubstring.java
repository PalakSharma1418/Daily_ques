// Last updated: 8/6/2025, 4:44:06 PM
// class Solution {
//     public String removeOccurrences(String s, String part) {
//         while (s.contains(part)) {
//             s = s.replaceFirst(part, "");
//         }  

//         return s;
//     }
// }
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
    }
}