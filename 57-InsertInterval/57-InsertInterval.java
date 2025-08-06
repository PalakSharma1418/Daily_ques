// Last updated: 8/6/2025, 4:50:42 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalList= new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        Collections.sort(intervalList,(a,b) -> Integer.compare(a[0],b[0]));
        return merge(intervalList.toArray(new int[intervalList.size()][]));
    }
      public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans= new ArrayList<>();
        for(int i=0;i< intervals.length;i++){
            int start=intervals[i][0];
            int end= intervals[i][1];
            while(i+1<intervals.length && end>=intervals[i+1][0]){
                // overlap
                end= Math.max(intervals[i+1][1],end);
                i++;
            }
             ans.add(new int[]{start , end});
        }
        int[][] arr = ans.toArray(new int[ans.size()][]);
        return arr;
    }
}
