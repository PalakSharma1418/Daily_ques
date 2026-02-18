// Last updated: 2/18/2026, 11:34:33 AM
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i< bulbs.size() ; i++){
            if(set.contains(bulbs.get(i))){
                set.remove(bulbs.get(i));
            }else{
                set.add(bulbs.get(i));
            }
        }
        ArrayList<Integer> as = new ArrayList<>();
        for(int j : set){
            as.add(j);
        }
        Collections.sort(as);
        return as;
    }
}