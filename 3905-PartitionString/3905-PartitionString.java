// Last updated: 8/6/2025, 4:40:45 PM
class Solution {
    public List<String> partitionString(String s) {
        Set<String> seen = new HashSet<>();
        List<String> ans= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(!seen.contains(sb.toString())){
                ans.add(sb.toString());
                seen.add(sb.toString());
                sb.setLength(0);//reset
            }
        }
        return ans;
    }
}