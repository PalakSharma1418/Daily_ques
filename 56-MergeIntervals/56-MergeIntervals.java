// Last updated: 8/6/2025, 4:50:43 PM
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int n= intervals.length;
        ArrayList<int[]> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            int start= intervals[i][0];
            int end= intervals[i][1];
            while(i+1<n && end>= intervals[i+1][0]){
                end=Math.max(end,intervals[i+1][1]);
                i++;
            }
            ans.add(new int[]{start,end});
        }
    
    return ans.toArray(new int[ans.size()][]);}
}