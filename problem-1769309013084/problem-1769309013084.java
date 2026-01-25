// Last updated: 1/25/2026, 8:13:33 AM
1class Solution {
2    public int[] rotateElements(int[] nums, int k) {
3        int n = nums.length;
4        List<Integer> pos = new ArrayList<>();
5        for(int x:nums){
6            if(x>=0) pos.add(x);
7        }
8
9        int m= pos.size();
10        if(m==0 || m==1) return nums;
11
12        k=k%m;
13        reverse(pos,0,k-1);
14        reverse(pos,k,m-1);
15        reverse(pos,0,m-1);
16        int idx=0;
17        for(int i=0 ; i<n;i++){
18            if(nums[i]>=0) {
19                nums[i]=pos.get(idx);
20                idx++;
21            }
22            
23        }
24        return nums;
25    }
26    public void reverse (List<Integer>pos , int l , int r){
27        while(l<r){
28            int t = pos.get(l);
29            pos.set(l, pos.get(r));
30            pos.set(r,t);
31            l++;
32            r--;
33        }
34    }
35}