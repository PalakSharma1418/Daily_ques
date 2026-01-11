// Last updated: 1/11/2026, 8:38:12 AM
1class Solution {
2    public long countPairs(String[] words) {
3        int n = words.length;
4        long ans =0;
5        HashMap<String,Long> map = new HashMap<>();
6        for(int i=0; i< n ;i++){
7            String ke = fun(words[i]);
8            if(map.containsKey(ke)){
9                ans+= map.get(ke);
10                map.put(ke, map.get(ke)+1);
11            }else{
12                map.put(ke,1L);
13            }
14        }
15        return ans;
16    }
17    public static String fun(String s1 ){
18        if(s1.length()==0) return "";
19        StringBuilder sb = new StringBuilder();
20        for(int i=1 ; i< s1.length();i++){
21            int diff = (s1.charAt(i)-s1.charAt(i-1)+26)%26;
22            sb.append(diff).append("!");
23        }
24        return sb.toString();
25    }
26    
27}