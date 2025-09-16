// Last updated: 9/16/2025, 7:35:44 PM
class Solution {
    class Pair{
        char ch;
        int fr;
        Pair(char ch,int fr){
            this.ch=ch;
            this.fr=fr;
        }
    } 
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.fr - a.fr);
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c :s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        // while(!pq.isEmpty()){
        while(pq.size() > 0){
            Pair p =pq.poll();
            
            while(p.fr-- > 0) sb.append(p.ch);;
        }
        return sb.toString();
    }
}