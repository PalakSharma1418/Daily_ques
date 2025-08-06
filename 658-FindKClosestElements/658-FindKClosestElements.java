// Last updated: 8/6/2025, 4:47:15 PM
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ar = new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<k;i++){
            ar.add(arr[i]);
        }
        int s=0;
        for(int i=k;i<n;i++){
            if(Math.abs(arr[i]-x)<Math.abs(arr[s]-x)){
                ar.remove(0);
                ar.add(arr[i]);
                s++;;
            }
        }
        return ar;
    }
}