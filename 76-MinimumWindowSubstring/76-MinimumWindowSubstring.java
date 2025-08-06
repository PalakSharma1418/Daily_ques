// Last updated: 8/6/2025, 4:50:26 PM
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] freq = new int[128];        // ASCII frequency array
        for (char c : t.toCharArray()) {
            freq[c]++;   //this we get know how many char we need
        }
        int cnt = t.length();           
        int l = 0, r = 0;
        int start = 0, minLen = Integer.MAX_VALUE;

        while (r < s.length()) {
            char cr = s.charAt(r);
            if (freq[cr] > 0) cnt--;  //element fount which is present in t becoz we only inserted those only
            freq[cr]--; // decrease it 
            while (cnt == 0){ // window is valid
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                // now we are trying to minimize the widow
                char cl = s.charAt(l);
                // iska mtlb hum apni window mai se hata rhe hai
                freq[cl]++;              // "Return" char to freq

                // agar koi positive hai mtlb window valid hai
                if (freq[cl] > 0) {
                    cnt++;               // We now lack one needed char
                }
                l++;
            } 
             r++;
        }

        
        return (minLen == Integer.MAX_VALUE) 
            ? "" 
            : s.substring(start, start + minLen);
    }
}
// striver 