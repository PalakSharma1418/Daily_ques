// Last updated: 1/9/2026, 10:53:02 AM
class Solution {
    public int findChampion(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            map.get(s).put(d,0);
        }

        int[]indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int key :  map.get(i).keySet()){
                indegree[key]++;
            }
        }
        int c=0;
        int first=-1;
        for(int i =0;i<n;i++){
            if(indegree[i]==0){
                c++;
                if(first==-1) first=i;
            } 
        }

        return c==1?first:-1;
    }
}