// Last updated: 8/28/2025, 11:18:57 AM
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String k=getkey(strs[i]);
            if(!map.containsKey(k)){
                map.put(k,new ArrayList<>());
            }
            map.get(k).add(strs[i]);
        }
        // return new ArrayList<>(map.values());
        List<List<String>> ll = new ArrayList<>();
        for(String key : map.keySet()){
            ll.add(map.get(key));
        }
        return ll;
    }
    public String getkey(String s){
        int[] fr=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            fr[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<fr.length;i++){
            sb.append(fr[i]).append('#');
        }
        return sb.toString();
    }
}