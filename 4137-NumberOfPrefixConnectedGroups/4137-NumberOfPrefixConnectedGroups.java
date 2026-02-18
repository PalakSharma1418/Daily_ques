// Last updated: 2/18/2026, 11:34:40 AM
class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words){
            if(s.length()<k) continue;
            String pre = s.substring(0,k);
            map.put(pre , map.getOrDefault(pre,0)+1);
        }
        int c=0;
        for(String f : map.keySet()){
            if(map.get(f) >=2 ){
                c++;
            }
        }
        return c;
    }
}