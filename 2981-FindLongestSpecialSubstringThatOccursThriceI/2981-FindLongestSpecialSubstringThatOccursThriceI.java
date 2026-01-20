// Last updated: 1/20/2026, 3:05:17 PM
1class Solution {
2    public int maximumLength(String s) {
3        HashMap<String,Integer> map= new HashMap<>();
4        for(int i=0 ; i<s.length() ; i++){
5            for(int j=i+1; j<=s.length();j++){
6                String str = s.substring(i,j);
7               
8                boolean flage=true;
9                if(str.length()==1) {
10                     map.put(str,map.getOrDefault(str,0)+1);
11                     continue;
12                }
13                for(int k=0 ; k<str.length()-1 ; k++){
14                    if(str.charAt(k)!=str.charAt(k+1)){
15                        flage = false;
16                    }
17                }
18                if(flage){
19                     map.put(str,map.getOrDefault(str,0)+1);
20                }
21            }
22        }
23
24        int ans =-1;
25        for(String key : map.keySet()){
26            int no = map.get(key);
27            if(no>=3){
28                ans=Math.max(ans,(key.length()));
29            }
30        }
31        return ans;
32    }
33}