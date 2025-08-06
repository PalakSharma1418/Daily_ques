// Last updated: 8/6/2025, 4:42:04 PM
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] mat) {
        HashMap<Integer, Integer>map1=new HashMap<>();
        HashMap<Integer, Boolean>map2=new HashMap<>();
        

        int res[]=new int[2];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int num=mat[i][j];
                map1.put(num, map1.getOrDefault(num, 0)+1);
                map2.put(num, true);
            }
        }

        for(Integer x:map1.keySet()){
            if(map1.get(x)>1){
                res[0]=x;
                break;
            }
        }

        for(int i=1;i<=mat.length*mat[0].length;i++){
            if(map2.containsKey(i)!=true){
                res[1]=i;
                break;
            }
        }
        return res;
    }
}