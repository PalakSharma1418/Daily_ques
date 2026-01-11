// Last updated: 1/11/2026, 11:39:21 AM
1class Solution {
2    public int minLength(int[] nums, int k) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int left =0 ; 
5        int right =0 ;
6        int ans = Integer.MAX_VALUE;
7        int n = nums.length;
8        int sum=0;
9        while(right < n){
10            if (map.getOrDefault(nums[right], 0) == 0) {
11                sum += nums[right];
12            }
13            map.put(nums[right] , map.getOrDefault(nums[right] , 0)+1);
14            while(left<n && sum>=k){
15                ans = Math.min(right-left+1 , ans);
16                // yha se left se value hata te jana hia 
17                map.put(nums[left] , map.get(nums[left])-1);
18                if(map.get(nums[left])==0){
19                    sum-=nums[left];
20                }
21                left++;
22            }
23            right++;
24        }
25        return ans==Integer.MAX_VALUE?-1:ans;
26    }
27}