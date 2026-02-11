// Last updated: 2/11/2026, 7:19:56 AM
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        for(int x:nums){
            if(x>=0) pos.add(x);
        }

        int m= pos.size();
        if(m==0 || m==1) return nums;

        k=k%m;
        reverse(pos,0,k-1);
        reverse(pos,k,m-1);
        reverse(pos,0,m-1);
        int idx=0;
        for(int i=0 ; i<n;i++){
            if(nums[i]>=0) {
                nums[i]=pos.get(idx);
                idx++;
            }
            
        }
        return nums;
    }
    public void reverse (List<Integer>pos , int l , int r){
        while(l<r){
            int t = pos.get(l);
            pos.set(l, pos.get(r));
            pos.set(r,t);
            l++;
            r--;
        }
    }
}