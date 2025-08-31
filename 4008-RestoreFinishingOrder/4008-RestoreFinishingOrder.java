// Last updated: 8/31/2025, 4:24:58 PM
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for(int n : friends){
            set.add(n);
        }
        List<Integer> ll = new ArrayList<>();
        for(int id : order){
            if(set.contains(id)){
                ll.add(id);
            }
        }
        int arr []= new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            arr[i]=ll.get(i);
        }
        return arr;
    }
}