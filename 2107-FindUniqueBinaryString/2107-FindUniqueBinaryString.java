// Last updated: 8/6/2025, 4:44:01 PM
class Solution {
    public String findDifferentBinaryString(String[] nums) {
         int n = nums[0].length();

        ArrayList<String> nums2 = new ArrayList<>(Arrays.asList(nums));
        ArrayList<String> rr = new ArrayList<>();
        printBin("", n, rr);
        for (String r : rr) {
            if (!nums2.contains(r)) {
                return r;
            }
        }

        return "";
    }

    public void printBin(String soFar, int iterations, ArrayList<String> rr) {

        if (iterations == 0) {
            rr.add(soFar);

        } else {
            printBin(soFar + "0", iterations - 1, rr);
            printBin(soFar + "1", iterations - 1, rr);
        }
        return ;
    }
}