// Last updated: 9/13/2025, 7:29:46 PM
class Solution {
    class Item {
        String name;
        int priority;

        Item(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) {
                return b.priority - a.priority; // higher frequency first
            } else {
                return a.name.compareTo(b.name); // alphabetical order
            }
        });
       for(String key : map.keySet()){
            pq.add( new Item(key,map.get(key)));
        }
        List<String> ans = new ArrayList<>();
        while(k-- >0){
            String a = pq.poll().name;
            ans.add(a);
        }
        return ans;
    }
}