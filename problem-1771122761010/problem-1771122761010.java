// Last updated: 2/15/2026, 8:02:41 AM
1class Solution {
2    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
3        HashSet<Integer> set = new HashSet<>();
4        for(int i=0 ; i< bulbs.size() ; i++){
5            if(set.contains(bulbs.get(i))){
6                set.remove(bulbs.get(i));
7            }else{
8                set.add(bulbs.get(i));
9            }
10        }
11        ArrayList<Integer> as = new ArrayList<>();
12        for(int j : set){
13            as.add(j);
14        }
15        Collections.sort(as);
16        return as;
17    }
18}