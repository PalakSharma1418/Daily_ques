// Last updated: 8/6/2025, 4:41:25 PM
class Solution {
    public String findValidPair(String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        String ans="";
        for(int i=0;i<s.length()-1;i++){
            if((s.charAt(i) != s.charAt(i+1)) && map.get(s.charAt(i))== Character.getNumericValue(s.charAt(i)) && map.get(s.charAt(i+1))==Character.getNumericValue(s.charAt(i+1))){
                ans+=s.charAt(i);
                ans+=s.charAt(i+1);
                break;
            }
        }
        return ans;
    }
}