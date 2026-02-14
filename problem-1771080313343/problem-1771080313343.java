// Last updated: 2/14/2026, 8:15:13 PM
1class Solution {
2    public int prefixConnected(String[] words, int k) {
3        HashMap<String,Integer> map = new HashMap<>();
4        for(String s : words){
5            if(s.length()<k) continue;
6            String pre = s.substring(0,k);
7            map.put(pre , map.getOrDefault(pre,0)+1);
8        }
9        int c=0;
10        for(String f : map.keySet()){
11            if(map.get(f) >=2 ){
12                c++;
13            }
14        }
15        return c;
16    }
17}