// Last updated: 11/4/2025, 1:09:53 PM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : sub) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            // yha sari key daal di or sort kar di
            List<Integer> key = new ArrayList<>(freq.keySet());
            Collections.sort(key , (a,b)->{
                if(! freq.get(a).equals(freq.get(b))){
                    return freq.get(b) - freq.get(a);
                }
                return b-a;
            });

            // upr se x nikal liye top bale
            Set<Integer> topX = new HashSet<>();
            for (int j = 0; j < Math.min(x, key.size()); j++) {
                topX.add(key.get(j));
            }

            int sum = 0;
            for (int num : sub) { // jo us subarray mai h freq vhi sum
                if (topX.contains(num)) sum += num;
            }

            ans[i] = sum; 
        }
        return ans;
    }
}