// Last updated: 8/6/2025, 4:48:01 PM
import java.util.*;
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int r=intervals.length;
        // int in=0;
        int[] ans=new int[r];
        for(int i=0;i<r;i++){
            int n=intervals[i][1];
            int c=-1;
            int mn=Integer.MAX_VALUE;
            for(int j=0;j<r;j++){
                    if(intervals[j][0]>=n){
                        mn=Math.min(mn ,intervals[j][0]);
                        if(mn == intervals[j][0]){
                            c=j;
                        }
                    }
                
            }
            
            ans[i]=c;
        }
        return ans;
    }
}