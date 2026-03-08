// Last updated: 3/8/2026, 12:23:42 PM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        int n = nums[0].length();
4        ArrayList<String> nums2 = new ArrayList<>(Arrays.asList(nums));
5        ArrayList<String> rr = new ArrayList<>();
6        printBin("", n, rr);
7        for (String r : rr) {
8            if (!nums2.contains(r)) {
9                return r;
10            }
11        }
12        return "";
13    }
14
15    public void printBin(String soFar, int iterations, ArrayList<String> rr) {
16        if (iterations == 0) {
17            rr.add(soFar);
18        } else {
19            printBin(soFar + "0", iterations - 1, rr);
20            printBin(soFar + "1", iterations - 1, rr);
21        }
22        return ;
23    }
24}