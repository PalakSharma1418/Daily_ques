// Last updated: 12/11/2025, 7:32:30 AM
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