// Last updated: 12/14/2025, 7:40:03 PM
1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3        List<List<Integer>> ans = new ArrayList<>();
4        int len = nums.length;
5        Arrays.sort(nums);
6        for (int i = 0; i < len - 3; i++) {
7            if (i > 0 && nums[i - 1] == nums[i]) 
8                continue;
9            for (int j = i + 1; j < len - 2; j++) {
10                if (j > i + 1 && nums[j - 1] == nums[j])
11                    continue;   
12                int k = j + 1;
13                int l = len - 1;
14                while (k < l) {
15                    long sum = nums[i] + nums[j];
16                    sum += nums[k] + nums[l];
17                    if (sum == target) {
18                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
19                        k++;
20                        l--;
21                        while (k < l && nums[k - 1] == nums[k]) k++;
22                        while (k < l && nums[l + 1] == nums[l]) l--;
23                    } else if (sum < target)
24                        k++;
25                    else 
26                        l--;
27                }
28            }
29        }
30
31        return ans;
32    }
33}