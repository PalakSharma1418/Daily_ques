// Last updated: 2/11/2026, 7:19:52 AM
class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i =0 ; i< n ; i++){
            map.put(i,new ArrayList<Integer>());
        }

        for(int i=0 ; i< edges.length; i++){
            int src = edges[i][0];
            int des= edges[i][1];
            map.get(src).add(des);
            map.get(des).add(src);
        }

        int[] dx= dist(map,x,n);
        int[] dy = dist(map,y,n);
        int[] dz= dist(map,z,n);

        int co=0;
        for(int i=0 ; i<n ; i++){
            int a = dx[i];
            int b = dy[i];
            int c = dz[i];
            // int[] arr = {a,b,c};
            // Arrays.sort(arr);
            int max=a,min=a,smx=a;
            max=Math.max(a,Math.max(b,c));
            min=Math.min(a,Math.min(b,c));
            smx=(a+b+c)-(max+min);

            if(min*min+smx*smx == max*max ){
                co++;
            }
        }
        return co;
    }

    public int[] dist(Map<Integer,List<Integer> >map , int src , int n){
        int[]dis= new int[n];
        Arrays.fill(dis,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src]=0;

        while(!q.isEmpty()){
            int rm = q.poll();

            for(int key : map.get(rm)){
                if(dis[key]==-1){
                    dis[key]=dis[rm]+1;
                    q.add(key);
                }
            }
        }
    return dis;
    }
}