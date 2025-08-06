// Last updated: 8/6/2025, 4:46:00 PM
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int peakVal = mountainArr.get(peak);

        if (target == peakVal) return peak;
        if (target > peakVal) return -1;
        int index = binarySearch(mountainArr, target, 0, peak, true);  // search left 
        if (index != -1) return index;
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false); // right (descending)
    }

    private int findPeak(MountainArray arr) {
        int s = 0, e = arr.length() - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr.get(m) < arr.get(m + 1)) s = m + 1;
            else e = m;
        }
        return s;
    }

    private int binarySearch(MountainArray arr, int target, int s, int e, boolean isAsc) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            int val = arr.get(m);

            if (val == target) return m;

            if (isAsc) {
                if (val < target) s = m + 1;
                else e = m - 1;
            } else {
                if (val > target) s = m + 1;
                else e = m - 1;
            }
        }
        return -1;
    }
}
// hint dusri id