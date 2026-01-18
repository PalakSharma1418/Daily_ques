// Last updated: 1/18/2026, 8:59:15 AM
1class Solution {
2    public int maxCapacity(int[] costs, int[] capacity, int budget) {
3        int n = costs.length;
4        int [][] pair = new int[n][2];
5        for(int i =0 ; i<n ; i++){
6            pair[i][0]= costs[i];
7            pair[i][1] = capacity[i];
8        }
9        Arrays.sort(pair ,(a,b) -> a[0]-b[0]);
10        return helper(pair , budget);
11    }
12    public static int helper(int[][] pair , int budget){
13        int n = pair.length;
14        int cap=0;
15        for(int i =0 ; i<n ; i++){
16            if(pair[i][0]<budget){
17                cap=Math.max(cap,pair[i][1]);
18            }
19        }
20        int[] pre = new int[n];
21        pre[0]= pair[0][1];
22        for(int i=1 ; i<n ; i++){
23            pre[i] = Math.max(pre[i-1] , pair[i][1]);
24        }
25
26        int l=1;
27        while(l<n){
28            int cuur_cap= pair[l][1];
29            int curr_cost = pair[l][0];
30            int rem = budget-curr_cost;
31            if(rem<=0) {
32                l++;
33                continue;
34            }
35            int r = ui(pair,rem,l-1);
36            if(r==-1){
37                l++;
38                continue;
39            }
40            cap=Math.max(cap,cuur_cap+pre[r]);
41            
42            l++;
43        }
44        return cap;
45        
46    }
47    public static int ui(int[][]arr , int t , int h ){
48        int l =0 ;
49        int ans=-1;
50        while(l<=h){
51            int mid = l+(h-l)/2;
52            if(arr[mid][0]<t){
53                ans=mid;
54                l=mid+1;
55            }else{
56                h=mid-1;
57            }
58        }
59        return ans;
60    }
61}