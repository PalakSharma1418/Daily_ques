// Last updated: 1/30/2026, 6:40:58 PM
1class Solution {
2    public long perfectPairs(int[] nums) {
3        int n = nums.length;
4        long[] abs= new long[n];
5        for(int i=0;i<n;i++){
6            abs[i]= Math.abs((long)nums[i]);
7        }
8        Arrays.sort(abs);
9        long c=0;
10        int r=0;
11        for(int l=0;l<n;l++){
12            if(r<=l) r=l+1;
13            while(r<n && abs[r]<=2*abs[l]){
14                r++;
15            }
16            c+=(r-l-1);
17        }
18        return c;
19    }
20}