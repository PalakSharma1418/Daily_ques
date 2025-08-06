// Last updated: 8/6/2025, 4:43:48 PM
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int refill = 0;
        int left = 0;
        int right = plants.length - 1;
        int currA = capacityA; 
        int currB = capacityB;

        while (left < right) {
            if (currA < plants[left]) {
                refill++;
                currA = capacityA; 
            }
            currA -= plants[left];
            if (currB < plants[right]) {
                refill++;
                currB = capacityB;
            }
            currB -= plants[right];

            left++;
            right--;
        }
        if (left == right) {
            if (Math.max(currA, currB) < plants[left]) {
                refill++;
            }
        }

        return refill;
    }
}
