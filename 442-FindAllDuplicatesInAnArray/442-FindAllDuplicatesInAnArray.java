// Last updated: 8/6/2025, 4:47:56 PM
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        if(nums.length==1){
            return duplicates;
        }
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] arr = new int[max + 1];
        Arrays.fill(arr, 0);
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i <= max; i++) { 
            if (arr[i] > 1) {
                duplicates.add(i); // Add the actual number, not the count
            }
        }

        return duplicates;
    }
}