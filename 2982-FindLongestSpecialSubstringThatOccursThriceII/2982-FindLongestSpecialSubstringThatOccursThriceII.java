// Last updated: 1/20/2026, 4:03:08 PM
1class Solution {
2    public int maximumLength(String s) {
3        int n=s.length();
4        int[] len=new int[n];
5        len[0]=1;
6        for(int i=1;i<n;i++){
7            if(s.charAt(i)==s.charAt(i-1)){
8                len[i]=len[i-1]+1;
9            }else{
10                len[i]=1;
11            }
12        }
13        HashMap<Character,List<Integer>> map=new HashMap<>();
14        for(int i=0;i<n;i++){
15            if(map.containsKey(s.charAt(i))){
16                map.get(s.charAt(i)).add(len[i]);
17            }else{
18                map.put(s.charAt(i),new ArrayList<>());
19                map.get(s.charAt(i)).add(len[i]);
20            }
21        }
22        for(List<Integer> ls:map.values()){
23            Collections.sort(ls,Collections.reverseOrder());
24        }
25        int ans=-1;
26        for(List<Integer> ls:map.values()){
27            if(ls.size()>=3){
28                ans=Math.max(ans,ls.get(2));
29            }
30        }
31        return ans;
32    }
33}