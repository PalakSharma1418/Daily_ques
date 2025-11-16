// Last updated: 11/16/2025, 8:06:40 AM
class Solution {
    public int minLengthAfterRemovals(String s) {
        int ac=0,bc=0;
        for(char ch : s.toCharArray()){
            if(ch=='b') bc++;
            else ac++;
        }
        return Math.abs(ac-bc);
    }
}