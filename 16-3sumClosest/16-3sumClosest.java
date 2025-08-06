// Last updated: 8/6/2025, 4:51:33 PM
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetsum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int currentsum=nums[i]+nums[left]+nums[right];
                if(Math.abs(target-currentsum)<Math.abs(target-closetsum)){
                    closetsum=currentsum;
                }
                if(currentsum<target){ left++;}
                else if(currentsum> target){ right--;}
                else { return target;}
            }
        }
        return closetsum;
    }
}