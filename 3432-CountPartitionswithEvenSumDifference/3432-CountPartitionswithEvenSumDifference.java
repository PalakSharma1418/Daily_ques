// Last updated: 12/5/2025, 7:59:43 PM
1class Solution {
2    public int countPartitions(int[] nums) {
3        int totalSum = 0;
4        for (int i=0;i<nums.length;i++) {
5            totalSum += nums[i]; 
6        }
7
8        int leftSum = 0;
9        int count = 0;
10
11        for (int i = 0; i < nums.length - 1; i++) { 
12            leftSum += nums[i]; 
13            int rightSum = totalSum - leftSum; 
14  
15            if ((leftSum % 2) == (rightSum % 2)) {
16                count++; 
17            }
18        }
19        return count; 
20    }
21    }