// Last updated: 8/6/2025, 4:46:12 PM
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
       int[] ans = new int[nums.length];
		int count = 0;
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] %2==0) {
				sum = sum+nums[i];
			}
		}
		
		
		for(int [] query : queries) {
			int index = query[1];
			int val = query[0];
			
			if(nums[index] %2==0) {
				int contri = nums[index];
				sum = sum-contri;
				nums[index] = nums[index]+val;
				if(nums[index] %2==0) {
					sum = sum +nums[index];
				}
			}
			else {
				nums[index] = nums[index]+val;
				if(nums[index] %2==0) {
					sum += nums[index];
				}
			}
			ans[count] = sum;
			count++;
			
		}
		
		return ans;

    }
}
