// Last updated: 2/11/2026, 7:19:45 AM
class Solution {
    public long countPairs(String[] words) {
        int n = words.length;
        long ans =0;
        HashMap<String,Long> map = new HashMap<>();
        for(int i=0; i< n ;i++){
            String ke = fun(words[i]);
            if(map.containsKey(ke)){
                ans+= map.get(ke);
                map.put(ke, map.get(ke)+1);
            }else{
                map.put(ke,1L);
            }
        }
        return ans;
    }
    public static String fun(String s1 ){
        if(s1.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i< s1.length();i++){
            int diff = (s1.charAt(i)-s1.charAt(i-1)+26)%26;
            sb.append(diff).append("!");
        }
        return sb.toString();
    }
    
}