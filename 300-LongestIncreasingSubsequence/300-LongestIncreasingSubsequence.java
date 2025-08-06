// Last updated: 8/6/2025, 4:48:37 PM
class Solution {
    //greedy + binary search approach (also known as Patience Sorting technique), 
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (res.isEmpty() || res.get(res.size() - 1) < n) {
                res.add(n);
            } else {
                int idx = binarySearch(res, n);
                res.set(idx, n);
            }
        }

        return res.size();        
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }    
}
// if we found smaller number, we should replace any number with current smaller number, because there is possilibity that curernt smaller number may be starting number of Longest Increasing Subsequence.
