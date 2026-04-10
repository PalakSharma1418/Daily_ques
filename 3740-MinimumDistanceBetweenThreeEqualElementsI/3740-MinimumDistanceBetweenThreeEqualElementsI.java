// Last updated: 4/10/2026, 8:29:31 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int  n = nums.length;
4        int ans=Integer.MAX_VALUE;
5        boolean f=false;
6        for(int i=0;i<n;i++){
7            for(int j=i+1;j<n;j++){
8                for(int k=j+1;k<n;k++){
9                    if(nums[i]==nums[j] && nums[j]==nums[k]){
10                        int d=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
11                        ans=Math.min(d,ans);
12                        f=true;
13                    }
14                }
15            }
16        }
17            if(!f) return -1;
18            return ans;
19        
20    }
21}