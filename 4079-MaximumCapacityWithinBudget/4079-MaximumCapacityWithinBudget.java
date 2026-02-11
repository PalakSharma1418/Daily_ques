// Last updated: 2/11/2026, 7:20:12 AM
class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int [][] pair = new int[n][2];
        for(int i =0 ; i<n ; i++){
            pair[i][0]= costs[i];
            pair[i][1] = capacity[i];
        }
        Arrays.sort(pair ,(a,b) -> a[0]-b[0]);
        return helper(pair , budget);
    }
    public static int helper(int[][] pair , int budget){
        int n = pair.length;
        int cap=0;
        for(int i =0 ; i<n ; i++){
            if(pair[i][0]<budget){
                cap=Math.max(cap,pair[i][1]);
            }
        }
        int[] pre = new int[n];
        pre[0]= pair[0][1];
        for(int i=1 ; i<n ; i++){
            pre[i] = Math.max(pre[i-1] , pair[i][1]);
        }

        int l=1;
        while(l<n){
            int cuur_cap= pair[l][1];
            int curr_cost = pair[l][0];
            int rem = budget-curr_cost;
            if(rem<=0) {
                l++;
                continue;
            }
            int r = ui(pair,rem,l-1);
            if(r==-1){
                l++;
                continue;
            }
            cap=Math.max(cap,cuur_cap+pre[r]);
            
            l++;
        }
        return cap;
        
    }
    public static int ui(int[][]arr , int t , int h ){
        int l =0 ;
        int ans=-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid][0]<t){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}